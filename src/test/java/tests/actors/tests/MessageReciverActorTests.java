package tests.actors.tests;

import actors.MessageReciverActor;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.Creator;
import akka.testkit.TestKit;
import org.junit.Test;


/**
 * Created by amine on 28/12/17.
 */
public class MessageReciverActorTests extends TestKit{

    static ActorSystem _system = ActorSystem.create();

    // Given : Actor message handler running
    static ActorRef myFriend = _system.actorOf(Props.create(new Creator<Actor>() {
        @Override
        public Actor create() throws Exception {
            return new MessageReciverActor();
        }
    }));


    public MessageReciverActorTests() {
        super(_system);
    }

    @Test
    public void anActorCanHandleReceivedMessages() throws Exception {

        // When : I send message "Who is my friend ?"
        myFriend.tell("Who is my friend ?", super.testActor());

        // Then The Actor message handler print "I'm your friend"
        expectMsg("I'm your friend");
    }

}
