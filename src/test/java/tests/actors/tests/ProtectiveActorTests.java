package tests.actors.tests;

import actors.ProtectiveActor;
import actors.comands.AbstractCommand;
import actors.comands.BadCommand;
import actors.comands.HandledComand;
import actors.exceptions.SupectCommandeException;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.TestActor;
import akka.testkit.TestProbe;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProtectiveActorTests extends ActorsTestsInitialiser {


    @Test(expected = SupectCommandeException.class)
    public void protectiveActorShouldProtectHimSelfFromSuspectedCommandes() {

        // Given : protective Actor running, Stream of comands
        final ActorRef protectiveActor = systeme.actorOf(Props.create(ProtectiveActor.class));
        final List<AbstractCommand> comands = Arrays.asList(new HandledComand("handledComand1"), new BadCommand("badComand"), new HandledComand("handledComand2"));
        TestProbe testProbe = TestProbe.apply(systeme);


        // When : I send stream of commands containing suspected command
        comands.stream().forEach(comand -> {
            protectiveActor.tell(comand, actorsTestKit.testActor());
            TestActor.Message message = testProbe.lastMessage();

        });


        // Then The protective Actor throw me an exception

    }
}
