# TODO list:

Add control where user can see if an order is pending or already confirmed.

Prevent back button to return an order after confirming an order (javascript related)

Rename url "viewItemController" to "main" and rename the url to the main.jsp in the customer folder to something else. Url name used by sendRedirect and forms should be succinct. 
similar cases include: confirmOrderController,

Provide protection for all pages which is displaying something forwarded by a controller or a jsp.
Such pages include: confirmOrderController, MakePayment,..

All methods in Dao has been changed to static. Don't create any Dao object. Change old statements to match new one.

provide more meal, add categories, pages,...

Add two payment method: local and 3rd party. Only re-enter password, we don't need to re-enter username.

what should we do in printslip ?

Add a message and a link in case there is no order in pending order or paid order.
