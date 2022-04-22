### DDD 

- This is a repository for the DDD training.

#### Context
- This is for Delivericious food delivery app
- We learnt about the domain already on Event Storming session and identified bounded contexts. 
- This repository demonstrates usage of Tactical Pattern of DDD. 

##### Use cases: 
1. Add  tomato soup to Basket
2. Add **Sea Food salad** which costs **$12.00**
3. Add **3** chocolate ice cream to Basket which cost **4$**
4. Removes 1 chocolate ice cream from the basket
5. Allow users to duplicate basket
6. Review the total price for the current basket

##### Notes:
1. Add  tomato soup to Basket
2. Add **Sea Food salad** which costs **$12.00**
    1. Introduce Money object with value and currency
3. Add **3** chocolate ice cream to Basket which cost **4$**
4. Removes 1 chocolate ice cream from the basket
    1. Add id to the food (MenuItem) for comparison
    2. basket.reduceFoodQuantity(Food, quantity)
        1. find -> optionalBasketItem
        2. basketItem.reduceQuantity()
5. Allow users to duplicate basket
    1. basket id should not be the same as duplicated basket id
6. Review the total price for the current basket

##### Links:
**DDD**
- [Entity vs Value Object](https://enterprisecraftsmanship.com/posts/entity-vs-value-object-the-ultimate-list-of-differences/)
- [Representing a collection as a Value Object](https://enterprisecraftsmanship.com/posts/representing-collection-as-value-object/)

**Java Stuffs**
- [Factory Method versus Constructor](https://www.artima.com/articles/josh-bloch-on-design#part13)
