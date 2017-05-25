
Ball a;
void setup() {
  /*ellipse(30.0f, 30f, 10f, 10f);
  size(300, 800);
  ellipse(50.0f, 40f, 10f, 10f);
  */
  size(400, 400);
  a = new Ball(30f, 30f, 20f);
}

void draw() {
  println(keysPressed);
  a.update();
  a.display();
}


//better event handlers, properly handles held down keys (I think)
/*improvements:
*/
//char tempKey;
ArrayList<Character> keysPressed = new ArrayList<Character>();
void keyPressed(KeyEvent k) {
    //println("in mine");
    //println(k.getKey() + " " + k.isAutoRepeat() + KeyEvent.KEY);
    
    //gets the currently pressed key
    key = k.getKey();
    
    //if the key is already being pressed, add it to the currently pressed keys
    if (!keysPressed.contains(key)) keysPressed.add(key);
    //tempKey = key;
    keyPressed = true;
}

void keyReleased(KeyEvent k) {
  key = k.getKey();
  
  //remove the released key from the list of currently pressed keys
  while (keysPressed.contains(new Character(key))) {
    keysPressed.remove(new Character(key));
  }
  
  //if (tempKey == key) keysPressed.remove(new Character(key));
  
  //if no keys currently being pressed
  if (keysPressed.size() <= 0) {
    keyPressed = false;
  }
}