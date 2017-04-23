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

➢	Filters can be used for ingredient substitution, e.g. spaghetti squash in lieu of spaghetti.  

Justification of Patterns

Factory Method: We are using Factory Method to categorize food groups to make sure the users are inputting proper ingredients and also to make it easier to display what they can add on the UI. Each ingredient will be a flyweight object to maximize memory efficiency.

Filter: The Filter pattern will be used to replace ingredients within a recipe. This modified recipe will then be available to all of the users within the recipe session. 

Decorator (Wrapper): We are using Decorator to allow users to combine recipes or to modify an existing recipe by “wrapping” a recipe into a recipe. By doing this, ingredients for the combined recipe can easily be accessed by unwrapping the recipe, and it allows reuse of common recipe objects.

Observer: We are using Observer to send messages to all users currently working together. 

Scheduler: The Scheduler pattern will be used to ensure that user requests for modification of recipes and additions to their ingredients occur in order and one at a time. 

Programming Language Chosen: We will be using Java because we have experience with networking, databases, and threading from previous classes. 
