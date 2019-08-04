# gbstag : Java GBS tag reader (Game Boy Sound Files)

[gbsTag](https://github.com/ullenius/gbstag) is a Java stand-alone command line
app for reading the tags from Game Boy music files (GBS).

GBS-files are sound files containing ripped chiptune music from Game Boy and
Game Boy Colour games. GBS stands for Game Boy Sound System.

## Usage

```sh
usage: gbstag <filename>
 -v,--verbose   verbose output
 -V,--version   print version
```

For example:
```sh
$ java -jar gbstag "/warez/gbs/dkland2.gbs"

Title		 : Donkey Kong Land 2
Artist(s)	 : Grant Kirkhope
Copyright	 : 1996 Rare, Nintendo
First Songs	 : 1
Total Songs	 : 28
```

## Features
* :heavy_check_mark: 100% Java (Java 8) :coffee:
* :heavy_check_mark: Supports Latin-1 (ISO-8859-1) encoding in the tags!
* :heavy_check_mark: Command line. Multi-platform.
* :heavy_check_mark: Batch processing using wildcards is possible! E.g. `java -jar gbstag *.gbs`
* :x: Edit tags (as of yet)

## Building
This is a Maven-project.

Run:
```sh
mvn clean install assembly:single
```
to build the JAR-file.

## Binaries
I've included a compiled jar-file with /lib dir to simplify for end-users who can't compile stuff on their platform.
* Download **gbstag-bin.zip**


## Development
1. I wrote this because there was a lack of tools supporting the GBS-format.
1. And it would be a fun project

Heavily based on the SPCtag code (equivalent tool for SNES SPC-files).

Java is multi-platform and you can run and compile 20-year old Java programs without any issues. So I'd figure this would be a suitable platform for posterity.

## Changelog
* 0.1 - first release! August 2019

## Licence
GPL 3 only. See COPYING

### Libraries and copyright
* Apache Commons CLI-library - Apache Licence version 2
