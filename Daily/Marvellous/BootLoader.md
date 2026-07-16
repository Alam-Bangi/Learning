```
A bootloader is a small program that runs right after the computer is powered on.
Its job is to load the operating system (OS) into RAM and start it.

⚙️ Where It Fits in Startup
Power ON → ROM (BIOS/UEFI) → Bootloader → OS Kernel → Programs

🔹 What Bootloader Does (in simple terms)
Gets control from firmware (BIOS/UEFI)
Finds the operating system on disk
Loads the OS kernel into RAM
Transfers control to the kernel

🔥 Why It Exists
Without a bootloader:
The system wouldn’t know where the OS is
You’d have to load programs manually (like early computers)

👉 Bootloader automates startup.

💡 Simple Analogy
ROM (BIOS) = person who turns on the system
Bootloader = person who brings the OS into memory
OS = the one who runs everything afterward

Eg: 
A common bootloader:
GRUB (Grand Unified Bootloader) — used in Linux systems

⚡ One-Line Summary
👉 Bootloader = bridge between hardware startup and operating system execution
```