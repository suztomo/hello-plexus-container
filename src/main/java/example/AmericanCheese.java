package example;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;

/**
 * AmericanCheese is the default cheese in most places. So here we are using it as the default component. Note: no
 * <code>hint</code> is specified.
 */
@Component( role = Cheese.class )
public class AmericanCheese
    implements Cheese
{
  @Requirement
  Logger logger;

  public void slice( int slices )
  {
    this.logger.info( "Slicing the cheese: " + slices + " times." );
  }

  public String getAroma()
  {
    return "plastic";
  }
}