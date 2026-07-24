# Operating System (OS)

**An Operating System (OS) is system software that acts as an interface between the user and the computer hardware. It manages the computer's resources, controls hardware devices, and provides services that allow application programs to run.**

## Five Major Functions of an Operating System

## 1. Process Management

**Process Management** is the function of an operating system that creates, schedules, executes, and terminates processes (running programs).

A **process** is a program that is currently being executed.

### Functions

* Creates new processes.
* Allocates CPU time to processes.
* Switches between multiple processes (multitasking).
* Synchronizes processes.
* Terminates processes after completion.

### Example

Suppose you open:

* Google Chrome
* Microsoft Word
* Music Player

The operating system manages all three processes by sharing CPU time, making them appear to run simultaneously.

### Importance

* Enables multitasking.
* Improves CPU utilization.
* Prevents conflicts between running programs.

---

# 2. File Management

**File Management** is the function of the operating system that organizes, stores, retrieves, and protects files and folders on storage devices.

### Functions

* Create files and folders.
* Delete files.
* Rename files.
* Copy and move files.
* Organize files into directories.
* Control file permissions.

### Example

When you save:

```text
Project.docx
```

The operating system:

1. Stores the file on the SSD/HDD.
2. Records its location.
3. Makes it available for future access.

### Importance

* Keeps data organized.
* Makes files easy to locate.
* Protects important information from unauthorized access.

---

# 3. Memory Management

**Memory Management** is the function of the operating system that controls the allocation and deallocation of **RAM** to programs.

### Functions

* Allocates memory to running applications.
* Frees memory when programs close.
* Prevents memory conflicts.
* Manages virtual memory.
* Tracks memory usage.

### Example

Suppose:

* Chrome needs **800 MB**
* Word needs **300 MB**
* Paint needs **200 MB**

The operating system allocates RAM to each program and ensures they do not interfere with one another.

### Importance

* Efficient use of RAM.
* Supports multiple running programs.
* Prevents memory shortages and crashes.

---

# 4. CPU Scheduling

**CPU Scheduling** is the process by which the operating system decides **which process should use the CPU and for how long**.

Since many programs may be ready to run at the same time, the scheduler chooses the next process based on a scheduling algorithm.

### Functions

* Selects the next process to execute.
* Shares CPU time among processes.
* Improves system performance.
* Reduces waiting time.
* Ensures fair CPU usage.

### Example

Three processes are ready:

```text
Chrome
Word
Music Player
```

The operating system quickly switches the CPU between them, giving each process a small time slice.

### Importance

* Improves response time.
* Maximizes CPU utilization.
* Supports smooth multitasking.

---

# 5. Hardware Abstraction

**Hardware Abstraction** is the function of the operating system that hides the complexity of hardware and provides a simple, consistent interface for applications.

Applications interact with the operating system instead of directly controlling hardware.

### Functions

* Provides standard interfaces for hardware.
* Manages communication with devices through **device drivers**.
* Allows the same software to run on different hardware configurations.
* Simplifies application development.

### Example

When you click **Print**:

1. Microsoft Word sends the print request to the operating system.
2. The operating system communicates with the printer using the appropriate driver.
3. The printer prints the document.

The application does not need to know the printer's internal hardware details.

### Importance

* Simplifies software development.
* Improves hardware compatibility.
* Allows hardware to be replaced or upgraded without changing applications.

---

# Summary Table

| Function                 | Purpose                                                   | Example                                                                                       |
| ------------------------ | --------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| **Process Management**   | Creates, executes, and terminates processes.              | Running Chrome and Word together.                                                             |
| **File Management**      | Organizes and manages files and folders.                  | Saving `Project.docx` to an SSD.                                                              |
| **Memory Management**    | Allocates and frees RAM for programs.                     | Giving RAM to Chrome, Word, and Paint.                                                        |
| **CPU Scheduling**       | Decides which process gets CPU time.                      | Switching rapidly between multiple applications.                                              |
| **Hardware Abstraction** | Hides hardware details and provides a standard interface. | Printing a document through the operating system instead of directly controlling the printer. |

## Easy Way to Remember

Use the mnemonic **PFMCH**:

* **P** – **Process Management** → Manages running programs.
* **F** – **File Management** → Manages files and folders.
* **M** – **Memory Management** → Manages RAM.
* **C** – **CPU Scheduling** → Decides which process uses the CPU.
* **H** – **Hardware Abstraction** → Hides hardware complexity and provides a common interface.
