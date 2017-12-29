package tests.actors.tests;

import actors.ProtectiveActor;
import actors.comands.AbstractCommand;
import actors.comands.BadCommand;
import actors.comands.HandledComand;
import actors.exceptions.SupectCommandeException;
import akka.actor.ActorRef;
import akka.actor.Props;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProtectiveActorTests extends ActorsTestsInitialiser {



    @Test(expected = SupectCommandeException.class)
    public void protectiveActorShouldProtectHimSelfFromSuspectedCommandes() {

        // Given : protective Actor running, Stream of comands
        Props actProps = Props.create(ProtectiveActor.class);
        final ActorRef protectiveActor = systeme.actorOf(actProps);
        final List<AbstractCommand> comands = Arrays.asList(new HandledComand("handledComand1"), new BadCommand("badComand"), new HandledComand("handledComand2"));


/*        final Props supervisorProps = BackoffSupervisor.props(Backoff.onFailure(
                actProps,
                "streamActor",
                Duration.create(3, TimeUnit.SECONDS),
                Duration.create(30, TimeUnit.SECONDS),
                0.2)
                .withAutoReset(Duration.create(10, TimeUnit.SECONDS))
                .withSupervisorStrategy(
                        new OneForOneStrategy(10, Duration.create("1 minute"),
                                DeciderBuilder.match(SupectCommandeException.class
                                        , e -> {throw new SupectCommandeException();}).build())
        ));

        systeme.actorOf(supervisorProps, "streamActorSupervisor");*/


        // When : I send stream of commands containing suspected command
        comands.stream().forEach(comand -> {
            protectiveActor.tell(comand, actorsTestKit.testActor());
        });


        // Then The protective Actor throw me an exception

    }
}
