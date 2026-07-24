# Computer Architecture

## 1. Microprocessor

### Definition

A **microprocessor** is an integrated circuit (IC) that acts as the **Central Processing Unit (CPU)** of a computer. It executes instructions, performs calculations, and controls all operations of the computer.

It is often called the **brain of the computer**.

### Main Functions

* Executes program instructions.
* Performs arithmetic and logical operations.
* Controls data flow between memory and I/O devices.
* Manages communication with other hardware.

### Main Parts of a Microprocessor

* **ALU (Arithmetic Logic Unit):** Performs calculations and logical operations.
* **Control Unit (CU):** Controls and coordinates the execution of instructions.
* **Registers:** Store temporary data and addresses.

### Example

When you open a web browser:

1. The microprocessor fetches the browser instructions from memory.
2. It decodes the instructions.
3. It executes them.
4. The browser window appears on the screen.

### Importance

* Executes all computer programs.
* Controls all hardware operations.
* Determines the overall performance of the computer.

---

# 2. Math Co-Processor (Floating Point Unit - FPU)

### Definition

A **Math Co-Processor** is a specialized processor designed to perform complex mathematical calculations, especially **floating-point arithmetic**, faster than the main CPU.

In modern processors, the FPU is built into the CPU.

### Functions

* Floating-point calculations
* Scientific computations
* Trigonometric calculations
* Matrix operations
* Graphics calculations

### Example

Calculating:

```text
25.678 × 45.234
```

The FPU performs this calculation efficiently.

### Applications

* Scientific software
* Engineering applications
* 3D graphics
* CAD software
* Video games

### Importance

* Speeds up mathematical computations.
* Reduces the workload on the main CPU.
* Improves performance in graphics and scientific applications.

---

# 3. Motherboard

### Definition

The **motherboard** is the **main printed circuit board (PCB)** of a computer. It connects and allows communication between all hardware components.

### Components on a Motherboard

* CPU socket
* RAM slots
* Chipset
* Expansion slots (PCIe)
* Storage connectors (SATA, M.2)
* BIOS/UEFI chip
* USB ports
* Audio ports
* Network port
* Power connectors

### Functions

* Connects all components.
* Supplies power to components.
* Enables communication between devices.
* Holds firmware (BIOS/UEFI).

### Importance

Without the motherboard, the computer components cannot communicate or work together.

---

# 4. Storage Devices

### Definition

**Storage devices** store data, programs, and operating systems either temporarily or permanently.

### Types

1. Primary Storage

   * RAM
   * ROM
   * Cache

2. Secondary Storage

   * HDD
   * SSD
   * USB drive
   * DVD
   * Memory card

### Importance

* Stores user data.
* Stores the operating system.
* Saves applications and documents.

---

# 5. RAM (Random Access Memory)

### Definition

RAM is the computer's **temporary working memory**.

It stores programs and data currently being used by the CPU.

### Characteristics

* Volatile memory (data is lost when power is off)
* Fast
* Read and write memory

### Example

When you open:

* Microsoft Word
* Chrome
* Photoshop

They are loaded into RAM.

### Importance

* Faster program execution.
* Supports multitasking.
* Provides temporary workspace for the CPU.

---

# 6. ROM (Read Only Memory)

### Definition

ROM is **permanent memory** that stores firmware required to start the computer.

### Characteristics

* Non-volatile
* Permanent storage
* Mostly read-only during normal operation

### Example

The BIOS/UEFI firmware is stored in ROM.

### Importance

* Starts the computer.
* Initializes hardware before the operating system loads.
* Retains data without power.

---

# 7. HDD (Hard Disk Drive)

### Definition

An HDD is a secondary storage device that stores data on **magnetic spinning disks (platters)**.

### Components

* Platters
* Read/Write head
* Motor
* Controller board

### Characteristics

* Large storage capacity
* Lower cost
* Mechanical parts
* Slower than SSD

### Advantages

* Affordable
* Large capacities (1 TB, 2 TB, etc.)

### Disadvantages

* Slower access speeds.
* More prone to mechanical failure.

---

# 8. SSD (Solid-State Drive)

### Definition

An SSD stores data using **flash memory chips** and has **no moving parts**.

### Characteristics

* Very fast
* Silent operation
* Durable
* Lower power consumption

### Advantages

* Faster boot times.
* Faster file transfers.
* Better durability.
* Lower energy use.

### Disadvantages

* More expensive per GB than HDD.

---

# HDD vs SSD

| Feature      | HDD            | SSD          |
| ------------ | -------------- | ------------ |
| Technology   | Magnetic disks | Flash memory |
| Speed        | Slower         | Much faster  |
| Moving Parts | Yes            | No           |
| Noise        | Audible        | Silent       |
| Durability   | Lower          | Higher       |
| Cost         | Lower          | Higher       |

---

# 9. Input Devices

### Definition

Input devices allow users to enter data and instructions into the computer.

### Examples

* Keyboard
* Mouse
* Scanner
* Webcam
* Microphone
* Joystick
* Barcode Reader
* Touchscreen

### Functions

* Accept user input.
* Convert input into digital signals.
* Send data to the CPU.

### Example

Typing:

```text
Hello
```

The keyboard sends the corresponding digital codes to the computer.

---

# 10. Output Devices

### Definition

Output devices present processed information from the computer to the user.

### Examples

* Monitor
* Printer
* Speakers
* Projector
* Plotter

### Functions

* Display results.
* Produce printed documents.
* Play audio.

### Example

After calculating:

```text
25 + 30
```

The monitor displays:

```text
55
```

---

# 11. System Bus

### Definition

The **system bus** is a communication pathway that connects the CPU, memory, and input/output devices.

It transfers:

* Data
* Memory addresses
* Control signals

### Types of Buses

* Address Bus
* Data Bus
* Control Bus

### Importance

Without the system bus, computer components could not communicate.

---

# 12. Address Bus

### Definition

The **address bus** carries the **memory address** of the location that the CPU wants to access.

### Characteristics

* Usually **unidirectional** (CPU → Memory/I/O).
* Determines the maximum amount of memory the CPU can address.

### Example

Suppose the CPU needs data stored at memory location:

```text
1000
```

The address bus carries:

```text
Address = 1000
```

to RAM.

### Importance

Helps the CPU identify the correct memory location for reading or writing data.

---

# 13. Data Bus

### Definition

The **data bus** transfers the **actual data** between the CPU, memory, and input/output devices.

### Characteristics

* **Bidirectional** (data can move in both directions).
* The width of the data bus (e.g., 32-bit or 64-bit) affects how much data can be transferred at once.

### Example

CPU reads:

```text
55
```

from memory.

The value **55** is transferred through the data bus.

### Importance

Transfers information required for program execution.

---

# 14. Control Bus

### Definition

The **control bus** carries **control and timing signals** between the CPU and other components.

### Examples of Signals

* Read
* Write
* Interrupt
* Clock
* Reset

### Example

When reading data from RAM:

1. The CPU places the memory address on the address bus.
2. It sends a **Read** signal over the control bus.
3. RAM responds by placing the requested data on the data bus.

### Importance

Coordinates and synchronizes operations between hardware components.

---

# How They Work Together (Example)

Suppose you save a file:

1. **Keyboard (Input Device):** You press **Ctrl + S**.
2. **Microprocessor:** Processes the save command.
3. **RAM:** Holds the document temporarily.
4. **Address Bus:** Specifies where the data should be stored.
5. **Control Bus:** Sends the **Write** signal to the storage device.
6. **Data Bus:** Transfers the document's data.
7. **SSD/HDD (Storage Device):** Permanently stores the file.
8. **Monitor (Output Device):** Displays "File Saved Successfully."

---

# Summary Table

| Component                   | Function                                                            |
| --------------------------- | ------------------------------------------------------------------- |
| **Microprocessor**          | Executes instructions and controls the computer.                    |
| **Math Co-Processor (FPU)** | Performs complex mathematical and floating-point calculations.      |
| **Motherboard**             | Connects and enables communication between all hardware components. |
| **Storage Devices**         | Store data, programs, and the operating system.                     |
| **RAM**                     | Temporary, fast memory for running programs.                        |
| **ROM**                     | Permanent memory that stores firmware (BIOS/UEFI).                  |
| **HDD**                     | Magnetic secondary storage with high capacity.                      |
| **SSD**                     | Flash-based secondary storage with high speed and durability.       |
| **Input Devices**           | Enter data and instructions into the computer.                      |
| **Output Devices**          | Present processed information to the user.                          |
| **System Bus**              | Connects the CPU, memory, and I/O devices.                          |
| **Address Bus**             | Carries memory addresses from the CPU to memory or I/O devices.     |
| **Data Bus**                | Transfers data between the CPU, memory, and I/O devices.            |
| **Control Bus**             | Carries control and timing signals to coordinate operations.        |
