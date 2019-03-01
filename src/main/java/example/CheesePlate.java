package example;


import java.util.List;
import java.util.Map;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

@Component(role = Plate.class)
public class CheesePlate
    implements Plate {

  /**
   * Inject the default cheese.
   */
  @Requirement
  private Cheese americanCheese;

  /**
   * Inject the default cheese, this does the same as the previous line.
   */
  @Requirement(hint = "default")
  private Cheese moreAmericanCheese;

  /**
   * Inject the ParmesanCheese.
   */
  @Requirement(hint = "parmesan")
  private Cheese parmesanCheese;

  /**
   * Inject all the cheese.  The container automatically add all the components defined with the
   * role <code>Cheese.class</code>.
   */
  @Requirement(role = Cheese.class)
  private List<Cheese> cheeses;

  /**
   * You can also inject the components as a Map, where the key is the Components
   * <code>hint</code>.
   */
  @Requirement(role = Cheese.class)
  private Map<String, Cheese> cheeseMap;

  public void printItems() {
    System.out.println("americanCheese smells like: " + americanCheese.getAroma());
    System.out.println("moreAmericanCheese smells like: " + moreAmericanCheese.getAroma());
    System.out.println("parmesanCheese smells : " + parmesanCheese.getAroma());

    System.out.println("\nThe List of cheeses has:");
    for (Cheese cheese : this.cheeses) {
      System.out.println("cheese: " + cheese.getClass().getSimpleName());
    }

    System.out.println("\nThe Map contains:");
    for (Map.Entry<String, Cheese> entry : this.cheeseMap.entrySet()) {
      System.out.println(
          "hint: " + entry.getKey() + ", value: " + entry.getValue().getClass().getSimpleName());
    }
  }
}