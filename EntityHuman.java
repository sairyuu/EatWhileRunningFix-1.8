Add this to your EntityHuman class, we'll use it on PlayerConnection later

// Myouren starts - fix eat while running
public boolean isBusy() {
  return this.bS() && this.g.getItem().e(this.g) == EnumAnimation.DRINK 
      || this.bS() && this.g.getItem().e(this.g) == EnumAnimation.EAT 
      || this.bS() && this.g.getItem().e(this.g) == EnumAnimation.BLOCK;
  }
// Myouren ends
