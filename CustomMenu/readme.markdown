CustomMenu
======================================================================

# Introduction

These classes provide a more flexible menu system that builds in a hierarchical left-to-right manner. All items are centered horizontally and vertically and by default will place everything on the same line.

In order to start a new vertical line simply add a br() 

# Dependencies

  * AndEngine (http://www.andengine.org/)

# Usage

Here is a complete example

	this.mMenuScene
		.add(new AnimatedSpriteMenuItem(MENU_WIN, ParticlyActivity.sTiledTextures.get("menuWin")))
		.br()
		.add("star1", new Sprite(200, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.add("star2", new Sprite(270, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.add("star3", new Sprite(340, 30, ParticlyActivity.sTextures.get("largeStarGlow")))
		.br()
		.add(new SpriteMenuItem(MENU_NEXT, ParticlyActivity.sTiledTextures.get("menuNext")))
		.add(new SpriteMenuItem(MENU_NEXT, ParticlyActivity.sTiledTextures.get("menuReset")))
		.br()
		.add(new SpriteMenuItem(MENU_NEXT, ParticlyActivity.sTiledTextures.get("menuSound")))			
		.add(new SpriteMenuItem(MENU_NEXT, ParticlyActivity.sTiledTextures.get("menuSelect")))
		.br();

# CustomMenuScene Functions

## add(Shape pEntity)
## add(String identifier, Shape pEntity)

The main function you use to add any Shape derived item (Sprite, Animated Sprite, Text, MenuItem etc...) to the Menu. If identifier is provided you can now reference this item later via myCustomMenuScene.mItems.get(identifier).

## br()
## br(float spacing)

Adds a break to move the next added item to a new line in the Menu. The optional spacing parameter will add padding between the lines.

## container()

Currently not working - do not use

## end()

Currently not working - do not use

# CustomMenuAnimator Functions

## constructor(float spacing)

You can initialize the animator with an optional spacing that will add padding around every item added to the menu.

# NOTES:

Setting an item to visible=false will make that object disappear from the menu and the space it takes up will no longer be there. In order for this to work properly you must call myCustomMenuScene.buildAnimations() after modifying any of the items you added.
