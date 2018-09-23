int maxBranchLength = 565;
int currentBranchLength = 0;
int maxSecondBranchLength = 0;
int secondBranchLength = 432;
int maxTreeHeight = 750;
int currentTreeHeight = 575;
int lineSpeed = 6;
boolean fullyGrown = false;

void setup() 
{
  size(768, 432);
}

void draw() 
{
  background(0, 104, 135);
  stroke(248, 169, 107);
  fill(0, 104, 135);
  strokeWeight(12);
  
  // Letter N
  line(30, 420, 30, 20);
  line(30, 20, 140, 420);
  line(140, 20, 140, 420);
  
  // Letter O
  ellipse(240, 220, 115, 400);
  
  // Letter A
  line(320, 420, 370, 20);
  line(420, 420, 370, 20);
  
  // Letter H
  line(460, 20, 460, 420);
  
  // Branches
  if (currentBranchLength < maxBranchLength) 
  {
    currentBranchLength = currentBranchLength + lineSpeed;
  }
  if (currentBranchLength >= maxBranchLength && secondBranchLength > maxSecondBranchLength) 
  {
    secondBranchLength = secondBranchLength - lineSpeed / 2;
    line(570, 432, 570, secondBranchLength);
  }
  
  line(0, 220, currentBranchLength, 220);
  
  if (secondBranchLength <= maxSecondBranchLength) 
  {
    line(570, 432, 570, secondBranchLength);
    fullyGrown = true;
  }
  if (fullyGrown && currentTreeHeight < maxTreeHeight) 
  {
    triangle(570, 30, 570, 410, currentTreeHeight, 220);
    currentTreeHeight = currentTreeHeight + 2;
  } 
  else if (fullyGrown && currentTreeHeight >= maxTreeHeight) 
  {
    triangle(570, 30, 570, 410, currentTreeHeight, 220);
    maxBranchLength = 780;
    line(0, 220, currentBranchLength, 220);
  } else if (currentBranchLength >= maxBranchLength) 
  {
    line(0, 220, currentBranchLength, 220);
  }
}
