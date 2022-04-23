## Use Cases And Notes
1. Add  tomato soup to Basket
2. Add **Sea Food salad** which costs **$12.00**
   - [X] Introduce Money object with value and currency
3. Add **3** chocolate ice cream to Basket which cost **4$**
4. Removes 1 chocolate ice cream from the basket
   - [X] Add id to the food (MenuItem) for comparison
   - [X] basket.reduceFoodQuantity(Food, quantity)
      1. find -> optionalBasketItem
      2. basketItem.reduceQuantity()
5. Allow users to duplicate basket
   - [X] basket id should not be the same as duplicated basket id
6. Review the total price for the current basket
7. Limit quantity of the basket items to 100
   ```
   Given a basket have total of 98,
   When user trying to add 3 seafood salads,
   Then this request should be rejected.
   ```
   - [X] Treat Exceptions as first class citizen, should create specific exception, use ubiquitous language.

8. Save the basket (using `hashmap <id, data>`)
   - [X] Hide the BasketItem from external world. (Basket as aggregate root)
   - [X] Use repository to allow retrieval and persistence as separate concern (**Persistence Ignorance Facade**)
      1. Aggregate could save into singleton repository, but it's required to understand the data model.

9. Suggest coupon
   ```
   If a basket have more than 5 soup (SOUP category), suggest coupon "DELIVERICIOUS_10" with 10% discount percentage if available. 
   
   Assumptions:
   - available coupons as input
   - tomato soup is in a SOUP category
   ```

10. xxx
   
## Reference Links
**DDD**
- [Event Storming Glossary](https://github.com/ddd-crew/eventstorming-glossary-cheat-sheet)
- [Entity vs Value Object](https://enterprisecraftsmanship.com/posts/entity-vs-value-object-the-ultimate-list-of-differences/)
- [Representing a collection as a Value Object](https://enterprisecraftsmanship.com/posts/representing-collection-as-value-object/)

**Java Stuffs**
- [Factory Method versus Constructor](https://www.artima.com/articles/josh-bloch-on-design#part13)
- [Java record types](https://howtodoinjava.com/java14/java-14-record-type/) : didn't seem to be supported by Jupiter?
