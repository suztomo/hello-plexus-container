package example;

import org.codehaus.plexus.component.annotations.Component;

/**
 * All we need to tell Plexus that this is a component.
 */
@Component( role = Cheese.class, hint = "parmesan" )
public class ParmesanCheese
    implements Cheese
{
  public void slice( int slices )
  {
    throw new UnsupportedOperationException( "No can do" );
  }

  public String getAroma()
  {
    return "strong";
  }
}