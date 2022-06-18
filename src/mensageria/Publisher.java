package mensageria;
                                                                           
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicPublisher;
import javax.jms.DeliveryMode;
import javax.jms.TopicSession;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
                                                                           
public class Publisher {

    private static final String PROPERTIES_PATH = "jndi.properties";
      
    public void enviarMensagem() throws Exception {
    	
        //Properties props = PropertiesReader.getProperties(PROPERTIES_PATH);
        /*
        // Step 1. Create an initial context to perform the JNDI lookup.
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("java.naming.factory.initial"));
		env.put(Context.URL_PKG_PREFIXES, props.getProperty("java.naming.factory.url.pkgs"));
		env.put(Context.PROVIDER_URL, props.getProperty("java.naming.provider.url"));
                
	Context ctx = new InitialContext(env);
        */
        
        Context ctx = new InitialContext();
        
        // lookup the topic object
        Topic topic = (Topic) ctx.lookup("topic/TopicoExemplo");
                                                                          
        // lookup the topic connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
            lookup("/ConnectionFactory");
                                                                          
        // create a topic connection
        TopicConnection topicConn = connFactory.createTopicConnection();
                                                                          
        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false, 
            Session.AUTO_ACKNOWLEDGE);
                                                                          
        // create a topic publisher
        TopicPublisher topicPublisher = topicSession.createPublisher(topic);
        topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                                                                          
        // create the "Hello World" message
        TextMessage message = topicSession.createTextMessage();
        
        message.setText("Atualize-se");
                                                                          
        // publish the messages
        topicPublisher.publish(message);
                                                                          
        // close the topic connection
        topicConn.close();
    }
}