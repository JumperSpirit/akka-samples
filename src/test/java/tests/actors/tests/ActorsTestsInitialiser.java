package tests.actors.tests;

import akka.actor.ActorSystem;
import akka.testkit.TestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ActorsTestsInitialiser {


    static ActorSystem systeme;
    static TestKit actorsTestKit;

    @BeforeClass
    public static void initialiseActorSystemForTesting(){
        systeme = ActorSystem.create("ActorSystem");
        actorsTestKit = new TestKit(systeme);
    }


    @AfterClass
    public static void shutDownActorSystemForTesting(){
        systeme.terminate();
    }

}
