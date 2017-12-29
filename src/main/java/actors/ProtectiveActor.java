package actors;

import actors.comands.BadCommand;
import actors.comands.HandledComand;
import actors.exceptions.SupectCommandeException;
import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Optional;

public class ProtectiveActor  extends AbstractActor {

    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .matchAny(comand-> {

                    if (comand instanceof BadCommand){
                        sendException((BadCommand) comand,getSender());
                    }
                    else {
                        handleComand((HandledComand) comand);
                    }
                })
                .build();
    }

    private void sendException(BadCommand comand,
                               ActorRef sender) throws Exception {
        logger.error(comand.getComandName());
        sender.tell(new Status.Failure(new SupectCommandeException()), getSelf());
    }

    private void handleComand(HandledComand comand) {
        logger.info(comand.getComandName());
    }

}