package example;

public interface Cheese {

  /**
   * Slices the cheese for apportioning onto crackers.
   *
   * @param slices the number of slices
   */
  void slice(int slices);

  /**
   * Get the description of the aroma of the cheese.
   *
   * @return the aroma
   */
  String getAroma();
}
