# Assignment 3 | Bridge Pattern

**Name:** Iskander Shaimerdinov  
**Group:** SE-2524  
**Topic:** B — Notifications  
**Repository:** https://github.com/IShaymerden/SDP_Assignment3.git

**Base Commit:** 11aa651

## 1. Project Overview

This project demonstrates the Bridge Design Pattern.

The project separates two independent dimensions:

- Notification type:
    - Reminder
    - UrgentAlert

- Delivery channel:
    - EmailChannel
    - SmsChannel
    - PushChannel

The `Notification` abstraction stores a reference to the `Channel` interface.  
This allows notification types and delivery channels to change independently.

## 2. Role Map

| Role | Class | Source |
|---|---|---|
| Abstraction | Notification | src/main/java/bridge/Notification.java |
| A1 | Reminder | src/main/java/bridge/Reminder.java |
| A2 | UrgentAlert | src/main/java/bridge/UrgentAlert.java |
| Implementor | Channel | src/main/java/bridge/Channel.java |
| I1 | EmailChannel | src/main/java/bridge/EmailChannel.java |
| I2 | SmsChannel | src/main/java/bridge/SmsChannel.java |
| I3 | PushChannel | src/main/java/bridge/PushChannel.java |
| Client | Main | src/main/java/Main.java |

## 3. Important Methods

### Bridge field
Located in `Notification.java`:

```java
protected Channel channel;