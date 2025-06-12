# Parking System LLD

## Overview

This project is a Low-Level Design (LLD) implementation of a Parking Lot Management System in Java. It models real-world parking operations, supporting multiple floors, various vehicle types, slot management, ticketing, and soft deletion of slots.

---

## Features

- **Multiple Floors:** Each floor can have a custom number and type of slots.
- **Vehicle Types:** Supports BIKE, CAR, TRUCK, ELECTRIC, SUV (extensible via `VehicleType` enum).
- **Slot Management:** Add, deactivate (soft delete), and manage slots per floor.
- **Vehicle Registration:** Register vehicles with type, registration number, and color.
- **Parking & Unparking:** Park and unpark vehicles, with ticket generation and management.
- **Ticketing:** Each parked vehicle gets a unique ticket; tickets are centrally managed.
- **Soft Delete:** Slots can be deactivated without being removed from the system.
- **Menu-Driven CLI:** Interactive command-line interface for demo and testing.

---

## Code Structure

- `ParkingLot.java` — Singleton class managing floors, tickets, and vehicles.
- `Floor.java` — Represents a parking floor, manages its slots.
- `Slot.java` — Represents a parking slot, supports soft delete.
- `Vehicle.java` — Represents a vehicle with type, registration number, and color.
- `VehicleType.java` — Enum for supported vehicle types.
- `Ticket.java` — Represents a parking ticket, links vehicle and slot.
- `Main.java` — Entry point with menu-driven CLI for user interaction.

---

## How to Run

1. **Clone the repository** and open in your Java IDE (e.g., VS Code, IntelliJ).
2. **Compile all `.java` files.**
3. **Run `Main.java`.**
4. **Follow the on-screen menu** to register vehicles, park/unpark, and view slot/ticket status.

---

## Example Usage

- Register a vehicle:  
  `1. register`
- Park a vehicle:  
  `2. park`
- Unpark a vehicle:  
  `3. unpark`
- View free/occupied slots:  
  `4. print free slots count`  
  `5. print free slots`  
  `6. print occupied slots`  
  `7. print all slots`
- Exit:  
  `8. exit`

---

## Extending the System

- **Add new vehicle types:** Edit `VehicleType.java`.
- **Add new slot features:** Extend `Slot.java`.
- **Enhance ticketing:** Add more fields or validation in `Ticket.java`.

---

## Notes

- The system uses soft delete for slots (`isActive` flag).
- All tickets are managed centrally in `ParkingLot`.
- Designed for clarity, extensibility, and easy testing.

---

## License

This project is for educational/demo purposes.