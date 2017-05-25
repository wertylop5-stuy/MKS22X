class Ball {
  public float posX;
  public float posY;
  public float radius;
  public float velocityX = 1;
  public float velocityY = 1;
  public float acceleration = 1;
  public float friction = .8; //not really friction, but whatevs
  //public boolean keyPressed;
  
  Ball(float x, float y){
    posX = x;
    posY = y;
    radius = 10f;
  }
  
  Ball(float x, float y, float r){
    posX = x;
    posY = y;
    radius = r;
  }
  
  //holding down on keys breaks it
  void update() {
    println(keyPressed + " " + key);
    if (keyPressed) {
      
      if (keysPressed.contains('d') || keysPressed.contains('D')) {
        background(100);
        velocityX += acceleration;
      }
      if (keysPressed.contains('s') || keysPressed.contains('S')) {
        background(100);
        velocityY += acceleration;
      }
      
      else background(0);
    }
    else {
      background(0);
      key = '\0';
      keyPressed = false;
    }
    velocityX -= friction;
    velocityY -= friction;
    if (velocityX < 0) velocityX = 0;
    if (velocityY < 0) velocityY = 0;
    posX += velocityX;
    posX %= width;
    
    posY += velocityY;
    posY %= height;
    if (posY < 0) posY = 0;
  }
  
  void display() {
    //background(0);
    ellipse(posX, posY, radius, radius);
  }
  
  
  
  /*
  void keyPressed() {
    if (key == 'w' || key == 'W') keyPressed = true;
  }
  
  void keyReleased() {
    if (key == 'w' || key == 'W') keyPressed = false;
  }
  */
}