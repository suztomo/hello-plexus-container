package suztomo;

import example.Plate;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;

public class App {

  public static void main(String[] args) throws Exception {
    // create a new container
    PlexusContainer container = new DefaultPlexusContainer();

    Plate plate = container.lookup(Plate.class);
    plate.printItems();

    // stop the components and container
    container.dispose();
  }
}
