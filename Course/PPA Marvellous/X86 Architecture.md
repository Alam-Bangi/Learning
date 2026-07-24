# X86 Architecture

Here's a step-by-step explanation of each component of the 'x86' toolchain.

## 1. Source Code

This is the code written by the programmer in a high-level language like C or C++.

**Example (C):**

```c
#include <stdio.h>

int main() {
    printf("Hello, World!");
    return 0;
}
```

**Purpose:**

* Easy for humans to read and write.
* Cannot be executed directly by the CPU.

---

## 2. Preprocessor

The **preprocessor** processes special directives (lines beginning with `#`) before compilation.

### What it does

* Includes header files (`#include`)
* Replaces macros (`#define`)
* Removes comments
* Handles conditional compilation (`#ifdef`, `#ifndef`)

### Example

Source code:

```c
#define PI 3.14
#include <stdio.h>

int main() {
    printf("%f", PI);
}
```

After preprocessing:

```c
/* Contents of stdio.h inserted */

int main() {
    printf("%f", 3.14);
}
```

**Output:** A preprocessed C file (often with a `.i` extension).

---

## 3. Compiler

The **compiler** translates the preprocessed C/C++ code into **assembly language**.

### Responsibilities

* Checks for syntax errors
* Performs optimizations
* Generates assembly instructions

### Example

C code:

```c
int add(int a, int b)
{
    return a + b;
}
```

Generated assembly (simplified):

```asm
add:
    mov eax, edi
    add eax, esi
    ret
```

**Output:** Assembly file (`.s`).

---

## 4. Assembler

The **assembler** converts assembly language into **machine code**.

### Input

```asm
mov eax, edi
add eax, esi
ret
```

### Output

Machine code (hex):

```
89 F8
01 F0
C3
```

The CPU understands only machine code (binary).

**Output:** Object file (`.o` or `.obj`).

---

## 5. Object File

An object file contains machine code, but it is **not yet a complete program**.

It contains:

* Machine instructions
* Symbol table
* Relocation information
* Debug information (optional)

Example:

```
main.o
math.o
display.o
```

Each source file usually becomes one object file.

---

## 6. Linker

The **linker** combines multiple object files and libraries into a single executable.

### Example

Suppose you have:

```
main.o
math.o
display.o
```

The linker combines them into:

```
program.exe
```

It also:

* Resolves function calls
* Resolves global variables
* Links standard libraries

Example:

```c
printf();
```

The linker finds the `printf()` implementation in the C standard library.

**Output:** Executable (`.exe` on Windows or an ELF executable on Linux).

---

## 7. Loader

The **loader** is part of the operating system.

When you run:

```
./program
```

The loader:

* Loads the executable into RAM
* Loads required shared libraries
* Sets up the program stack and heap
* Starts execution at the program's entry point

The program is now ready to execute.

---

## 8. CPU Execution

Now the x86 processor executes the machine instructions one by one.

Example:

```
MOV EAX, 5
ADD EAX, 3
```

Execution:

```
EAX = 5
EAX = EAX + 3
EAX = 8
```

The CPU repeats the **fetch–decode–execute** cycle until the program ends.

---

# Internal CPU Components

## Registers

Registers are very small, very fast storage locations inside the CPU.

Examples:

| Register | Purpose                                               |
| -------- | ----------------------------------------------------- |
| EAX/RAX  | Accumulator (stores calculation results)              |
| EBX/RBX  | General-purpose register                              |
| ECX/RCX  | Loop counter                                          |
| EDX/RDX  | Data register                                         |
| ESP/RSP  | Stack pointer                                         |
| EBP/RBP  | Base/frame pointer                                    |
| EIP/RIP  | Instruction pointer (address of the next instruction) |

Example:

```asm
mov eax, 10
```

Now:

```
EAX = 10
```

---

## ALU (Arithmetic Logic Unit)

The ALU performs arithmetic and logical operations.

Examples:

* Addition
* Subtraction
* Multiplication
* Division
* AND
* OR
* XOR
* NOT

Example:

```asm
add eax, ebx
```

If:

```
EAX = 10
EBX = 5
```

Result:

```
EAX = 15
```

---

## Control Unit

The control unit directs the CPU's operation.

It repeatedly performs:

1. Fetch the next instruction from memory.
2. Decode the instruction.
3. Execute it.
4. Store the result if needed.

For example:

```
MOV EAX, 5
```

The control unit:

* Fetches the instruction.
* Decodes it as a `MOV` operation.
* Signals the appropriate hardware to place the value `5` into the `EAX` register.

---

## Cache Memory

The CPU cache stores frequently accessed data and instructions so the processor doesn't have to fetch them from the much slower main memory (RAM) every time.

Typical cache hierarchy:

* **L1 Cache:** Smallest and fastest, closest to the CPU core.
* **L2 Cache:** Larger but slightly slower.
* **L3 Cache:** Shared among cores, larger but slower than L1/L2.

If data is found in the cache (a **cache hit**), access is much faster than reading from RAM.

---

## Main Memory (RAM)

RAM stores:

* Program instructions
* Variables
* Stack
* Heap

The CPU reads instructions and data from RAM (or cache) while executing a program.

---

## Instruction Set Architecture (ISA)

The **ISA** defines the machine instructions that the CPU understands and how they behave.

Examples of x86 instructions:

* `MOV` – Copy data
* `ADD` – Add values
* `SUB` – Subtract values
* `MUL` – Multiply
* `DIV` – Divide
* `JMP` – Unconditional jump
* `CALL` – Call a function
* `RET` – Return from a function
* `CMP` – Compare values
* `JE` – Jump if equal

Example:

```asm
mov eax, 5
mov ebx, 10
add eax, ebx
```

Result:

```
EAX = 15
```

---

# Complete Toolchain Flow

```
C Source Code
      │
      ▼
Preprocessor
      │
      ▼
Compiler
      │
      ▼
Assembly Code
      │
      ▼
Assembler
      │
      ▼
Object File
      │
      ▼
Linker
      │
      ▼
Executable
      │
      ▼
Loader (Operating System)
      │
      ▼
x86 CPU
      │
      ▼
Fetch → Decode → Execute
```
This sequence shows how a human-readable program is transformed into machine code and ultimately executed by the x86 processor.
