package tests.actors.tests;

import actors.CuteActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import org.junit.Test;


/**
 * Created by amine on 28/12/17.
 */
public class CuteActorTests extends ActorsTestsInitialiser {


    @Test
    public void anActorCanHandleReceivedMessages() throws Exception {

        // Given : Actor message handler running
        final ActorRef myFriend = systeme.actorOf(Props.create(CuteActor.class));

        // When : I send message "Who is my friend ?"
        myFriend.tell("Who is my friend ?", actorsTestKit.testActor());

        // Then The Actor message handler print "I'm your friend"
        actorsTestKit.expectMsg("I'm your friend");
    }

}
