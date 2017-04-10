# SWENG421_TeamProject
Motivation

Current Problems: Currently, there is no way for people to come up with meal ideas based on ingredients. 

Problems that are Resolved: This system will allow multiple individuals to state what ingredients they have and it will find a recipe for them that they can make. This will solve the problem of people not being able to collaborate to find recipes that each individual can make.

Features: Functional

➢	Multiple users can work together to make a recipe

➢	The system should pull recipes from a common database

➢	Users should be able to input ingredients that they possess

➢	Users should be able to input their own recipes

➢	Users can modify recipes

➢	Users can input filters 

Non-Functional:

➢	The system can be used by multiple users at a time on the same computer.

➢	Filters can include common allergies such as Peanut and Gluten Free.  

Justification of Patterns

Factory Method: We are using Factory Method to categorize food groups to make sure the users are inputting proper ingredients and also to make it easier to display what they can add on the UI. Each ingredient will be a flyweight object to maximize memory efficiency.

Filter: We are using Filter to provide criteria for finding information in the database. For instance, if a person requests gluten free ingredients only, a filter can be added to a recipe object so that it makes a call to the database and returns only the values that match the query. 

Decorator (Wrapper): We are using Decorator to allow users to combine recipes or to modify an existing recipe by “wrapping” a recipe into a recipe. By doing this, ingredients for the combined recipe can easily be accessed by unwrapping the recipe, and it allows reuse of common recipe objects.

Observer: We are using Observer to send messages to all users currently working together. 

Read/Write Lock: We are using Read/Write Lock to make sure only one person can edit the recipe or ingredients at a time. 

Programming Language Chosen: We will be using Java because we have experience with networking, databases, and threading from previous classes. 
