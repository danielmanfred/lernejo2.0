package br.com.lernejo.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 * Implementa as fases do JSF.
 */
public class PhaseListenerLernejo implements PhaseListener
{
    // Após a fase 
    @Override
    public void afterPhase(PhaseEvent fase) 
    {
        System.out.println("Depois a fase" + fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE))
        {
            // Obter a sessão de volta
            Session session = FacesContextUtil.getRequestSession();
            try
            {
                session.getTransaction().commit();
            }
            catch(Exception e)
            {
                if (session.getTransaction().isActive()) // Se ocorreu erro e a sessão ainda estiver ativa.
                {
                    session.getTransaction().rollback(); // Irá anular o que tiver sido inserido no banco de dados.
                }
            }
            finally
            {
                session.close(); // Encerrará a sessão.
            }
        }
    }

    // Anterior a fase
    @Override
    public void beforePhase(PhaseEvent fase) 
    {
        System.out.println("Anterior a fase" + fase.getPhaseId());
        // Se estiver tentando restaurar a visão
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW))
        {
            Session session = HibernateUtil.getSessionFactory().openSession(); // Abre uma sessão do hibernate
            session.beginTransaction(); // Inicia a transação
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    public PhaseId getPhaseId() 
    {
        return PhaseId.ANY_PHASE;
    }
    
}
