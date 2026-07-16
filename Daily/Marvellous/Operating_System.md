```
🔹 1. Process Management (Running Programs)
👉 Handles program execution

What it does:
Creates and deletes processes
Schedules CPU time (who runs when)
Handles multitasking
Example:
You open Chrome + Music + Editor
👉 OS decides which gets CPU time

🔹 2. Memory Management (RAM Control)
👉 Controls RAM usage

What it does:
Allocates memory to programs
Frees memory when done
Uses virtual memory (disk as extra RAM)
Example:
Your program gets its own memory space safely

🔹 3. File System Management (Storage)
👉 Manages files on disk

What it does:
Create, delete, read, write files
Organize directories
Track where data is stored on disk
Example:
When you open hello.txt, OS finds it and loads it

🔹 4. Device / I/O Management
👉 Controls hardware devices

What it does:
Communicates with keyboard, mouse, disk, display
Uses device drivers
Handles input/output operations
Example:
You press a key → OS captures it → sends to program

🔹 5. Security & Access Control
👉 Protects system and data

What it does:
User authentication (login)
Permissions (who can access what)
Isolates processes (prevents crashes spreading)
Example:
One app cannot access another app’s memory

🔹 6. What is Hardware Abstraction?
Hardware abstraction means hiding the complex details of hardware and giving programs a simple, consistent interface to use it.

👉 Instead of dealing with:
voltages
registers
device-specific commands

Programs just use:
functions
system calls
APIs

🔥 Why It Exists
Without abstraction:
Every program must know exact hardware details
Software would break on different machines

👉 With abstraction:
Same program runs on different hardware
Development becomes easier

🧩 Layered View (Very Important)
Application (your program)
        ↓
Operating System (Kernel)
        ↓
Device Drivers
        ↓
Hardware (CPU, RAM, Disk, I/O)

🔹 Key Components of Hardware Abstraction
1. 🧱 Operating System (OS)
Provides system calls
Example:
read(), write(), open()
👉 You don’t directly access disk hardware

2. 🔌 Device Drivers
Translate OS requests → hardware-specific instructions
Example:
OS: “Read file”
Driver: “Move disk head, read sector”

3. 🧠 Hardware Abstraction Layer (HAL)
Lowest abstraction layer
Hides hardware differences from OS

👉 Same OS can run on different machines
```
```
User → Application → OS
                    ↓
     ┌──────────────┼──────────────┐
     ↓              ↓              ↓
 Process       Memory         File System
 Management    Management     Management
     ↓              ↓              ↓
           Device / I-O Management
                    ↓
                 Hardware
````