ClassyCraft – UML Modeling Desktop Application

Overview: 

ClassyCraft is a desktop UML modeling tool developed in Java using Swing. The application enables users to design and manage object-oriented system diagrams through an interactive graphical interface. The project demonstrates implementation of advanced software architecture patterns, custom rendering logic, and state-based GUI interaction management.

Features: 

-Create and manage projects, packages, and diagrams 

-Add UML elements: Classes Interfaces Enums

-Add relationships: Association Aggregation Composition Dependency Generalization

-Interactive diagram editing (drag, connect, delete, edit) 

-Undo / Redo (Command pattern) 

-State-based mouse interaction

-Save / Load projects

-JSON serialization (Gson)

-Export diagram as image 

-Code export support 

-Logging system (console + file)

Architecture & Design Patterns: 

-The application follows a structured architecture with clear separation of concerns: 

-MVC-inspired GUI structure 

-Composite pattern (project tree hierarchy) 

-Factory pattern (node and diagram creation)

-Command pattern (Undo/Redo support)

-Observer pattern (event propagation)

-State pattern (diagram interaction modes)

-Repository pattern (project data management)

-Serializer layer (Gson-based persistence) This project emphasizes maintainable architecture rather than only GUI functionality.

Tech Stack:

-Java 

-Java Swing 

-Maven 

-Gson (JSON serialization)

Project Structure: 

-app/ 

– application core and command system gui/

– Swing interface and controllers repository/ 

– domain model and UML elements state/

– interaction state management serializer/ 

– JSON serialization/deserialization logg/ 

– logging system

How to Run: 

mvn clean

install mvn exec:java

Or open the project in IntelliJ IDEA and run the main class from AppCore.

Developed as part of a Software Design course, the project focuses on applying design patterns and architectural principles in a real-world modeling tool.

Authors:

Jovan Spasojevic

Milica Jocic
