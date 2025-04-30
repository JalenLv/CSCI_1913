// Name: Qiming Lyu

/**
 * This class implements a simple map data structure using two arrays.
 */
public class Map<Key, Value> {
  private Key[] keys;
  private Value[] values;
  private int count;

  /**
   * Constructor to initialize the `keys` and `values` arrays to have `length`
   * elements. If `length` is less than or equal to 0, the arrays will have 1
   * element.
   * 
   * @param length the length of the arrays
   */
  public Map(int length) {
    if (length <= 0) {
      keys = (Key[]) new Object[1];
      values = (Value[]) new Object[1];
    } else {
      keys = (Key[]) new Object[length];
      values = (Value[]) new Object[length];
    }
    count = 0;
  }

  /**
   * Helper function to test if two keys are equal.
   *
   * @param leftKey  the first key
   * @param rightKey the second key
   */
  private boolean isEqual(Key leftKey, Key rightKey) {
    if (leftKey == null && rightKey == null) {
      return true;
    }
    if (leftKey == null || rightKey == null) {
      return false;
    }
    return leftKey.equals(rightKey);
  }

  /**
   * Helper function to get the index of a key in the keys array.
   * Returns -1 if the key is not found.
   *
   * @param key the key to search for
   */
  private int getIndex(Key key) {
    for (int i = 0; i < count; i++) {
      if (isEqual(keys[i], key)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Retrieves the value associated with the given key.
   * If the key is not found, returns null.
   */
  public Value get(Key key) {
    int index = getIndex(key);
    if (index == -1) {
      return null;
    }
    return values[index];
  }

  /**
   * Tests if there is an element in `keys` that is equal to`key`.
   *
   * @param key the key to search for
   */
  public boolean containsKey(Key key) {
    return getIndex(key) != -1;
  }

  /**
   * Adds a key-value pair to the map. If the key does not exist, it adds the
   * key-value pair to the map. If the key already exists, it updates the value
   * associated with the key.
   *
   * @param key   the key to add
   * @param value the value to add
   */
  public void put(Key key, Value value) {
    int index = getIndex(key);

    // If the key exists, update the value
    if (index != -1) {
      values[index] = value;
      return;
    }

    // If the key does not exist, add the key-value pair
    // Resize the arrays if necessary
    if (count == keys.length) {
      resize();
    }
    // Add the new key-value pair
    keys[count] = key;
    values[count] = value;
    count++;
  }

  /**
   * Helper function to resize the keys and values arrays.
   */
  private void resize() {
    Key[] newKeys = (Key[]) new Object[keys.length * 2];
    Value[] newValues = (Value[]) new Object[values.length * 2];

    for (int i = 0; i < count; i++) {
      newKeys[i] = keys[i];
      newValues[i] = values[i];
    }

    keys = newKeys;
    values = newValues;
  }

  public int size() {
    return count;
  }
}
