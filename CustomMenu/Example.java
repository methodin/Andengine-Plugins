/*
Using the MenuExample from andengine
http://code.google.com/p/andengineexamples/source/browse/src/org/anddev/andengine/examples/MenuExample.java
*/

// Show the menu
public void showMenu(boolean showNext) {
	if(mScene.hasChildScene()) {
		// Remove the menu and reset it.
		this.mMenuScene.back();
	} else {
		this.mMenuScene.mItems.get("star3").setVisible(mAttempts <= 1 || showNext);
		this.mMenuScene.mItems.get("star2").setVisible(mAttempts <= 2 && showNext);
		this.mMenuScene.mItems.get("star1").setVisible(showNext);
	
		// Attach the menu.
		((AnimatedSpriteMenuItem)this.mMenuScene.mMenuItems.get(MENU_WIN)).setCurrentTileIndex(showNext ? 0 : 1);
		this.mMenuScene.mMenuItems.get(MENU_NEXT).setVisible(sStats.getMaxLevel() > mLevel);
		this.mMenuScene.buildAnimations();
	}
}

// Create the menu
protected void createMenuScene() {
	this.mMenuScene = new CustomMenuScene(this.mCamera);
	
	final AnimatedSpriteMenuItem winMenuItem = new AnimatedSpriteMenuItem(MENU_WIN, ParticlyActivity.sTiledTextures.get("menuWin"));
	winMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	winMenuItem.setCurrentTileIndex(0); 
	
	final SpriteMenuItem nextMenuItem = new SpriteMenuItem(MENU_NEXT, ParticlyActivity.sTextures.get("menuNext"));
	nextMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	
	final SpriteMenuItem resetMenuItem = new SpriteMenuItem(MENU_RESET, ParticlyActivity.sTextures.get("menuReset"));
	resetMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	
	final SpriteMenuItem selectMenuItem = new SpriteMenuItem(MENU_SELECT, ParticlyActivity.sTextures.get("menuSelect"));
	selectMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	
	final AnimatedSpriteMenuItem soundMenuItem = new AnimatedSpriteMenuItem(MENU_SOUND, ParticlyActivity.sTiledTextures.get("menuSound"));
	soundMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);			
	SharedPreferences settings = getSharedPreferences(Stats.PREFS_NAME, 0);
	mSound = settings.getBoolean("sound",true);
	soundMenuItem.setCurrentTileIndex(mSound?0:1);  

	this.mMenuScene
		.add(winMenuItem)
		.br()
		.add("star1", new Sprite(200, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.add("star2", new Sprite(270, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.add("star3", new Sprite(340, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.br()
		.add(nextMenuItem)
		.add(resetMenuItem)
		.br()
		.add(soundMenuItem)			
		.add(selectMenuItem)
		.br();
	
	mMenuScene.setMenuAnimator(new CustomMenuAnimator(5.0f));

	this.mMenuScene.buildAnimations();
	this.mMenuScene.setBackgroundEnabled(false);
	this.mMenuScene.setOnMenuItemClickListener(this);
}	
