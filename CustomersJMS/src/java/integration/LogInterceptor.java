/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 *
 * @author danecek
 */
@Interceptor
@LogInterceptorBinding
public class LogInterceptor {

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    ConnectionFactory cf;

    @Resource(lookup = "java:comp/env/jms/LogQueue")
    Destination destination;

    @AroundInvoke
    public Object invoke(InvocationContext ic) throws Exception {
        Logger.getAnonymousLogger().log(Level.INFO, "LogInterceptor: " + ic.getMethod().getName());
        sendJMSMessageToLogQueue(ic.getMethod().getName());
        return ic.proceed();
    }

    private Message createJMSMessageForjmsLogQueue(Session session, String messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData);
        return tm;
    }

    private void sendJMSMessageToLogQueue(String messageData) throws JMSException, NamingException {
        // Context c = new InitialContext();
        //  ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/java:comp/DefaultJMSConnectionFactory");
        //     Connection conn = null;

        try (Connection conn = cf.createConnection(); Session s = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
            //   Destination destination = (Destination) c.lookup("java:comp/env/jms/LogQueue");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForjmsLogQueue(s, messageData));
        }

    }

}
