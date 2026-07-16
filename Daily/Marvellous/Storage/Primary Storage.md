## RAM (Random Access Memory)
```
RAM is the computer’s main working memory.
It temporarily stores the data and instructions that the CPU is currently using.

👉 Think of RAM as your workspace (desk):
Programs you open → placed on the desk
CPU works directly on it
When power is OFF → everything is erased (volatile memory)

🔹 How RAM Works (Simple Flow)
Program is loaded from disk → into RAM
CPU reads instructions/data from RAM
CPU processes and writes results back to RAM
After program closes → RAM is freed

🔥 Key Properties of RAM
⚡ Fast (much faster than hard disk/SSD)
🔄 Volatile (data lost when power off)
🎯 Direct access (any location can be accessed quickly)

🧩 Types of RAM
1. SRAM (Static RAM)
🔹 How it works:
Uses flip-flops (transistors) to store data
No need to refresh

✔️ Advantages:
Very fast
Stable

❌ Disadvantages:
Expensive
Takes more space

📌 Used in:
👉 CPU cache (L1, L2, L3)

2. DRAM (Dynamic RAM)
🔹 How it works:
Stores data using capacitor (charge)
Needs constant refreshing

✔️ Advantages:
Cheap
High density (more memory in small space)

❌ Disadvantages:
Slower than SRAM
Needs refresh cycles

📌 Used in:
👉 Main system RAM (what you install in PC)
```
## ROM (Read Only Memory)
```
ROM is non-volatile memory that stores permanent instructions needed to start and control a computer.

👉 Unlike RAM:
RAM → temporary (erased when power off)
ROM → permanent (data stays even without power)

🔹 What ROM Does
Stores firmware (low-level software)
Contains startup instructions (boot process)
Initializes hardware when system turns ON

Example:
👉 When you press power:
ROM runs BIOS/UEFI
Then bootloader starts
Then OS loads

🔥 Key Properties
    💾 Non-volatile
    🔒 Mostly read-only
    ⚡ Slower than RAM
    🧩 Used for firmware storage

🧩 Types of ROM

1. Mask ROM (MROM)
🔹 Description:
Programmed during manufacturing
Cannot be changed

✔️ Advantages:
Very reliable
Cheap for mass production

❌ Disadvantages:
Cannot be updated

📌 Use:
Old embedded systems

2. PROM (Programmable ROM)
🔹 Description:
Can be programmed once by user
✔️ Advantage:
Customizable once
❌ Disadvantage:
Cannot be erased

3. EPROM (Erasable PROM)
🔹 Description:
Can be erased using ultraviolet (UV) light
Reprogrammable
✔️ Advantage:
Reusable
❌ Disadvantages:
Needs special UV light
Slow process

4. EEPROM (Electrically Erasable PROM)
🔹 Description:
Can be erased electrically
No need to remove from system
✔️ Advantages:
Easy to update
Flexible
❌ Disadvantage:
Slower write speed
```