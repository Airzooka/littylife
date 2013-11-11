Litty's Game of Life
====================

A Java implementation of Conway's Game of Life. Made with Slick2D, a game engine wrapper for LWJGL.

The repository is nested into directories to match the main Java package: com.alexlitty.asynchrony.littylife

Build Instructions
------------------

Before compiling, add the following .jar files (found in /lib) to the classpath:

```
lwjgl.jar
slick.jar
jinput.jar
lwjgl_util.jar
```

Change the Java library path to:

```
<x>/com/alexlitty/asynchrony/littylife/lib/natives/<y>
```

Where <x> is the absolute path to the repository, and <y> is either _windows_, _mac_, or _linux_.

If you're not using an IDE, a compile command would look like this:

```
javac -cp .:com/alexlitty/asynchrony/littylife/lib/* com/alexlitty/asynchrony/littylife/LittyLife.java
```

Play the game! I do recommend some breathing exercises and a therapist before you begin:

```
java -cp .:com/alexlitty/asynchrony/littylife/lib/* -Djava.library.path=x/com/alexlitty/asynchrony/littylife/lib/natives/y com/alexlitty/asynchrony/littylife/LittyLife
```
