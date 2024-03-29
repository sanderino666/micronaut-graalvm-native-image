package example.micronaut;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.inject.Singleton;

@Singleton
public class ConferenceService {

    private static final List<Conference> CONFERENCES = Arrays.asList(
            new Conference("Greach"),
            new Conference("GR8Conf EU"),
            new Conference("Micronaut Summit"),
            new Conference("Devoxx Belgium"),
            new Conference("Oracle Code One"),
            new Conference("CommitConf"),
            new Conference("Codemotion Madrid")
    );

    public Conference randomConf() {
        return CONFERENCES.get(new Random().nextInt(CONFERENCES.size()));
    }
}
