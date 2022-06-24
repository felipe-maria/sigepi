package br.com.fantonio.sigepi.mensageria;
                                                                           
import br.com.fantonio.sigepi.control.ChamadoControl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
                                                                           
import javax.jms.ConnectionFactory;
import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.MessageListener;
import javax.jms.JMSException;
import javax.jms.ExceptionListener;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
                                                 
// implementa a leituraa de um topico
public class AsyncSubscriber implements MessageListener, 
			ExceptionListener, Runnable {
	
    private static final String PROPERTIES_PATH = "br/com/fantonio/sigepi/main/resources/jndi.properties";
        
    @Override
    public void run() {
        try {
            rodar();
        } catch (Exception ex) {
            Logger.getLogger(AsyncSubscriber.class.getName()).log(Level.SEVERE, null, ex);        
        }
    }
    
    private void rodar() 
    		throws Exception {
    	/*
         * Quando o jndi.properties é definido, não precisa colocar as classes envolvidas
         * diretamente no codigo.
         * Detalhe. Em um projeto JSE, o properties deve ficar dentro do diretório src
         * 
         * 
    	Properties props = PropertiesReader.getProperties(PROPERTIES_PATH);
        
        // Step 1. Create an initial context to perform the JNDI lookup.
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("java.naming.factory.initial"));
		env.put(Context.URL_PKG_PREFIXES, props.getProperty("java.naming.factory.url.pkgs"));
		env.put(Context.PROVIDER_URL, props.getProperty("java.naming.provider.url"));
       
		Context ctx = new InitialContext(env);
	*/	
        
        Context ctx = new InitialContext();
        
	// Step 2. Lookup the connection factory
        ConnectionFactory connFactory = (ConnectionFactory)ctx.lookup("/ConnectionFactory");
                                                                          
        // create a topic connection
        TopicConnection topicConn = ((TopicConnectionFactory) connFactory).createTopicConnection();
                                                                          
        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false,
            Session.AUTO_ACKNOWLEDGE);
       
        // lookup the topic object
        Topic topic = (Topic) ctx.lookup("/topic/TopicoExemplo");
                                                                          
        // create a topic subscriber
        TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
                                                                          
        // set an asynchronous message listener
        AsyncSubscriber asyncSubscriber = new AsyncSubscriber();
        topicSubscriber.setMessageListener(asyncSubscriber);
                                                                          
        // set an asynchronous exception listener on the connection
        topicConn.setExceptionListener(asyncSubscriber);
                                                                          
        // start the connection
        topicConn.start();
                                                                          
        // wait for messages
        //System.out.print("waiting for messages");
        while (!Thread.interrupted()) {
            Thread.sleep(1000);
            //System.out.print(".");
        }
        //System.out.println();
                                                                          
        // close the topic connection
        topicConn.close();
    }
                                                                           
    /**
       This method is called asynchronously by JMS when a message arrives
       at the topic. Client applications must not throw any exceptions in
       the onMessage method.
       @param message A JMS message.
     */
    @Override
    public void onMessage(Message message) {
        
    	TextMessage msg = (TextMessage) message;
        ChamadoControl.getControl().atualizar();
        /*
        try {
           System.out.println("received: " + msg.getText());
        } catch (JMSException ex) {
           ex.printStackTrace();
        }
        */
    }
                                                                           
    /**
       This method is called asynchronously by JMS when some error occurs.
       When using an asynchronous message listener it is recommended to use
       an exception listener also since JMS have no way to report errors
       otherwise.
       @param exception A JMS exception.
     */
    @Override
    public void onException(JMSException exception)
    {
       System.err.println("something bad happended: " + exception);
    }    
}