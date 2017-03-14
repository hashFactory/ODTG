# ODTG
This is a little game we are making. Look away. We won't help with compilation.
# TODO
### Classes
#### Graphics package
1. TextureCreator
    * Gets all textures in grid from resources bundle
    * Cuts up the textures into array with IDs
    * Includes solely terrain
    * Multithreaded loader (hopefully)
2. SpriteCreator
    * Gets all textures from resources bundle
    * Creates custom animation filetype
    * Includes characters and items
3. Render
    * Initializes TextureCreator and SpriteCreator
    * Assigns rendering of the UI, Map, Characters, Objects, and Shaders
4. MapRender
    * Handles rendering of the map
    * Gets given map data
    * Uses instance of TextureCreator to render map
5. CharacterRender
    * Uses custom animation files to create animation instances of characters
    * Renders the actual character
6. ObjectRender
    * These are not the items in the game but the objects which are not part of tileset
    * Ex: Torches, chests, etc...
    * Calls Render's instance of ShaderRender
7. ShadeRender
    * Applies shaders to objects passed onto it
    * Uses layers of varying alpha to create effect
8. UIRender
    * Handles menus and statistics
    
#### Objects

1. ObjectList
    * ArrayList of superclass of objects
    * Will contain all IDs of subclasses in the arraylist
2. InventoryContent
    * Contains an ObjectList of the same length as the array
    
#### UIEngine

1. MainMenu
    * Contains all main menu buttons with hooks to methods
    * Gets drawn if invoked by Graphics.UIRender
2. PauseMenu
    * Same as MainMenu, but with settings and exit/save
3. SettingsMenu
    * Displays buttons with hooks to change xml of settings
    
#### Objects

##### TODO

#### AudioEngine

1. MusicLoader
    * Loads all pieces of music (Multithreaded if possible)
    * Referenced by array (subject to change to HashMap)
2. Music
    * Contains play/pause for song control
    * Accessed from Main
3. SoundLoader
    * Loads all sound effects
    * Also referenced by array (or HashMap)
4. Sound
    * Plays/pauses sounds
    * Gets info about "creators of sound" to create stereo effect
    
#### ProceduralGeneration

1. PlayerCreator
    * Creates player with random name and features
2. ChunkCreator
    * Based on nearby chunks and seed, created a new chunk in desired location
3. ChestCreator (Optional)
    * Returns objects that could be found in a chest
4. EnemyCreator
    * Based on nearby environment, create enemies with varying stats
    
#### InputEngine

1. KeyboardHandler
    * Gets called from Main
    * Handles the keyboard input for character movement
2. MouseHandler
    * Possibly a custom cursor
    * Interacts with UIEngine menus to do things
3. JoystickHandler (optional)
    * Interface for USB controller to use as game interface
    
#### Character

1. Protagonist
    * (TODO)
2. Enemies
    * Arraylist of subclasses of enemies with inherited properties (such as strength, etc...)
    
#### Main

1. MainApplet
    * Contains all function calls to orchestrate this miracle of a project
