package actors;

import actors.comands.BadCommand;
import actors.comands.HandledComand;
import actors.exceptions.SupectCommandeException;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;

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
        throw  new SupectCommandeException();
    }

    private void handleComand(HandledComand comand) {
        logger.info(comand.getComandName());
    }

}