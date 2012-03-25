Mineblocks is a simple plugin that adds new constructs to Minecraft. Currently it only
supports a drawbridge construct. A drawbridge can be constructed by placing an iron block
and putting stairs next to it. Powering the iron block will make it moving all blocks on top
of it (of the same type) horizontall opposite of the stairs (and vice-versa).

## Building

To build Mineblocks, you'll need a Java compiler and Maven 2.2 or later. Perform
the following:

1. Clone the Mineblocks Git repository:
   `git clone git://github.com/SiebeTolsma/Mineblocks.git`
2. Run Maven to build:
   `mvn clean package`
3. (Optional) Run convert.bat for Visual J# support:
   `cd ikvm; convert.bat`

Note that if you are using Visual J#, you will likely only want to `clean` once.
After that, simply run `mvn package` to build instead.

## Developing

Mineblocks welcomes contributions in the form of pull requests and issue reports. 
If you feel like working on Mineblocks, just fork the repository and start working. 
Once you're done submit a pull request.

Note that only pulls that adhere to the current coding styles are accepted. In 
short, put braces on a new line, use four spaces for indent, and at a minimum 
put a short Javadoc comment on each method.

## License

Copyright (C) 2012 Siebe Tolsma

This software is provided 'as-is', without any express or implied
warranty. In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not
   claim that you wrote the original software. If you use this software
   in a product, an acknowledgment in the product documentation would be
   appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be
   misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.

Siebe Tolsma
siebe@bot2k3.net