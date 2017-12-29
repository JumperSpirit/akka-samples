package actors;


import akka.actor.AbstractActor;

/**
 * Created by amine on 28/12/17.
 */
public class MessageReciverActor extends AbstractActor {


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("Who is my friend ?", message -> {
                    getSender().tell("I'm your friend", getSelf());
                })
                .build();
    }
}
