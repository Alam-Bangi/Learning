
------------------------------
## Part 1: The Modern java.nio.file.Files Class
These are static methods used to perform heavy operations on files. They all take a Path object as an argument. [6, 7, 8] 
## 1. Creation Functions

* Files.createFile(Path): Creates a new, empty file.
* Files.createDirectory(Path): Creates a single new folder.
* Files.createDirectories(Path): Creates a folder hierarchy (including any missing parent folders).
* Files.createTempFile(String prefix, String suffix): Creates an auto-named temporary file.
* Files.createTempDirectory(String prefix): Creates a temporary folder.
* Files.createSymbolicLink(Path link, Path target): Creates a shortcut/symbolic link to another file. [9, 10, 11, 12, 13] 

## 2. Writing & Modifying Functions

* Files.writeString(Path, CharSequence, OpenOption...): Writes text to a file as a single String.
* Files.write(Path, Iterable<? extends CharSequence>, OpenOption...): Writes a structured collection/list of text lines.
* Files.write(Path, byte[], OpenOption...): Writes raw binary data (images, PDFs, audio).
* Files.newBufferedWriter(Path, OpenOption...): Opens a buffered writer for memory-efficient text writing.
* Files.newOutputStream(Path, OpenOption...): Opens an output stream for writing raw bytes sequentially. [14, 15, 16, 17, 18] 

## 3. Reading Functions

* Files.readString(Path): Reads an entire file into memory as one String.
* Files.readAllLines(Path): Reads all file rows cleanly into a List<String>.
* Files.readAllBytes(Path): Reads everything as a raw byte[] array (for binary files).
* Files.lines(Path): Streams lines lazily (crucial for reading massive files without crashing).
* Files.newBufferedReader(Path): Opens an efficient buffered reader for text files.
* Files.newInputStream(Path): Opens an input stream for reading raw bytes sequentially. [19, 20, 21, 22, 23] 

## 4. Moving, Copying, & Deleting

* Files.copy(Path source, Path target, CopyOption...): Copies a file or folder to a new location.
* Files.move(Path source, Path target, CopyOption...): Moves or renames a file or folder.
* Files.delete(Path): Deletes a file. Throws an exception if the file doesn't exist.
* Files.deleteIfExists(Path): Deletes a file safely; returns false instead of crashing if the file is missing. [24, 25, 26, 27, 28] 

## 5. Search & Directory Exploration

* Files.list(Path): Lists all immediate items inside a specific directory.
* Files.walk(Path): Deeply explores a folder and all its subfolders recursively.
* Files.find(Path, int maxDepth, BiPredicate): Searches a directory structure for files matching a specific rule. [29, 30, 31, 32] 

------------------------------
## Part 2: The Core java.io.File Class
When you instantiate a File file = new File("path");, you get access to these powerful instance methods to check information about that specific path. [33] 
## 1. Verification & Type Checks

* file.exists(): Returns true if the file or folder physically exists on disk.
* file.isFile(): Returns true if the object is a normal file (not a folder).
* file.isDirectory(): Returns true if the object is a folder.
* file.isHidden(): Returns true if the operating system flags it as hidden.
* file.isAbsolute(): Returns true if the path provided is a full path (e.g., C:/Folder/file.txt). [34, 35, 36, 37, 38] 

## 2. Name & Path Extraction

* file.getName(): Gets just the file name with its extension (e.g., photo.png).
* file.getPath(): Gets the path string used to create the File object.
* file.getAbsolutePath(): Resolves and returns the full system path from the root directory.
* file.getParent(): Returns the string path of the folder holding this file.
* file.getParentFile(): Returns a new File object representing the parent folder.
* file.toPath(): Converts this legacy File object into a modern Java NIO Path object instantly. [39, 40, 41, 42, 43] 

## 3. Storage & Metadata Info

* file.length(): Returns the size of the file in bytes (returns 0L if it doesn't exist).
* file.lastModified(): Returns a long timestamp of when the file was last edited.
* file.getTotalSpace(): Returns the total storage size of the entire hard drive partition in bytes.
* file.getFreeSpace(): Returns the amount of unallocated empty space on the drive partition.
* file.getUsableSpace(): Returns the actual storage space available to this specific JVM program. [44, 45, 46, 47, 48] 

## 4. Permissions & Security

* file.canRead(): Returns true if your program is allowed to open and read the file.
* file.canWrite(): Returns true if your program has permission to modify the file.
* file.canExecute(): Returns true if the file can be run as a program/script.
* file.setReadOnly(): Locks the file so it can only be read, blocking any future edits.
* file.setWritable(boolean): Turns file write permissions on or off.
* file.setReadable(boolean): Turns file read permissions on or off.
* file.setExecutable(boolean): Turns file run permissions on or off. [49, 50, 51, 52, 53] 

## 5. Legacy Utility Operations

* file.createNewFile(): Old-school method to generate an empty file (returns false if it exists).
* file.mkdir(): Old-school method to create a single directory.
* file.mkdirs(): Old-school method to build nested parent directories.
* file.delete(): Old-school method to delete a file or an empty folder.
* file.deleteOnExit(): Instructs Java to automatically delete this file when the program finishes running.
* file.renameTo(File dest): Old-school method to rename or relocate a file.
* file.list(): Returns an array of strings containing the names of files in a directory.
* file.listFiles(): Returns an array of File objects pointing to items inside a directory. [54, 55, 56, 57, 58] 

