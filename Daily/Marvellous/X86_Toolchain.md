```
The x86 toolchain is the pipeline that turns your source code (e.g., hello.c) into a running program on an x86 CPU. It’s not one tool, but a sequence of stages:

Source → Preprocess → Compile → Assemble → Link → Load → Execute

Below is each stage in detail, with what files are produced and what actually happens internally.

🔹 1) Preprocessing (C → expanded C)
Tool: cpp (usually invoked by gcc/clang)
Command: gcc -E hello.c > hello.i

What it does
Expands #include (pulls in headers)
Replaces #define macros
Removes comments
Handles conditional compilation (#ifdef)

Output
hello.i (pure C after textual expansion)

Key idea
👉 This stage is text transformation, not compilation yet.

🔹 2) Compilation (C → x86 Assembly)
Tool: C compiler front/middle/back end (gcc or clang)
Command: gcc -S hello.i -o hello.s

Internals
Parsing → AST (checks syntax)
Semantic analysis (types, scopes)
IR (Intermediate Representation) (e.g., LLVM IR / GIMPLE)
Optimizations (inlining, constant folding, dead code elimination)
Code generation for x86 ISA
Output
hello.s (human-readable x86 assembly)
Example (simplified)
mov rdi, message
call puts

🔹 3) Assembling (Assembly → Object file)
Tool: as (GNU assembler)
Command: as hello.s -o hello.o

What it does
Converts assembly → machine code (binary)
Creates sections:
.text (code)
.data (initialized globals)
.bss (uninitialized globals)
Generates relocation info (addresses not yet final)
Output
hello.o (object file, not runnable yet)

🔹 4) Linking (Object(s) → Executable)
Tool: ld (linker) or via gcc hello.o -o hello

What it does
Combines your .o with libraries (e.g., libc)
Resolves symbols (e.g., printf)
Fixes addresses (applies relocations)
Produces final binary (usually ELF on Linux)
Static vs Dynamic
Static linking: everything included → big binary
Dynamic linking: uses shared libs (.so) at runtime
Output
hello (an ELF executable)

🔹 5) Loading (Disk → RAM)
Actor: OS (kernel) + loader

Steps
You run ./hello
Shell calls execve() (system call)
Kernel:
Reads ELF headers
Maps segments into memory:
Code → executable
Data → writable
Sets up stack (args, env)
If dynamically linked:
Loads dynamic linker (e.g., ld-linux)
Resolves shared libraries
Result
Process memory is ready

🔹 6) Execution (CPU runs it)
Entry point
CPU starts at _start (not main directly)
Runtime startup
_start (from C runtime, crt) sets things up
Calls main(argc, argv)
During execution
CPU runs fetch → decode → execute
Uses registers (RIP, RSP, RAX, …)
Function calls create stack frames
Syscalls (e.g., write to terminal) go to kernel

🔹 7) Output (e.g., printing “Hello”)
Your code calls printf
That lives in libc
Eventually makes a system call (e.g., write)
Kernel sends bytes to terminal device
```
```
⚡ Full Pipeline (one view)
hello.c
  ↓ (pre-processor)
hello.i
  ↓ (compiler)
hello.s
  ↓ (assembler)
hello.o
  ↓ (linker + libc)
hello (ELF)
  ↓ (OS loader)
Process in RAM
  ↓ (CPU)
Output
```
## How High level is converted to low level (C,C++)
```
Step 1: Programmer uses editor to write programs. We consider name file as hello.c.
        It is human readable and understandable.

Step 2: .c file is passed to pre-processor which generates expanded output file named 
        hello.i

Step 3: Output of pre-processor is passed as input to compiler which generates machine 
        dependant language that is assembly, output with file hello.asm

Step 4: Output of compiler is passed as input to assembler which generates machine 
        understandable output that is hello.obj

Step 5: Output of assembler is not complete , to link it with the dependant file linker is used.
        It generates an executable file hello.exe

Step 6: Currently hello.exe is stored inside hard-disk but to execute process we need to load 
        it into RAM. Loader is responsible to load it into RAM. After loading it into the RAM,
        it is treated as a process.
```