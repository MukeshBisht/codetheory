<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/header.jsp" />
    <script src="<c:url value=" /resources/script/register.js" />"></script>
    <form:form method="POST" name="f" action="/register" modelAttribute="registerForm">
            <section class="container cardView">
                <div class="container-page">
                    <div class="col-md-6">
                        <h3 class="dark-grey">
                            <p class="text-success text-center">Create Your CodeTheory Account.
                                <br>It will not take long.</p>
                            <hr/>
                        </h3>
                        <div class="form-group col-lg-12">
                            <form:label path="username">Username</form:label>
                            <form:input path="username" name="username" id="username" placeholder="Username eg. john12" class="form-control" required="true"/>
                            <div id="uname_response" class="response"></div>                        
                        </div>

                        <div class="form-group col-lg-6">
                            <form:label path="password">Password</form:label>
                            <form:input path="password" name="password" id="password" type="password" placeholder="Password" class="form-control" required="true"/>
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Repeat Password</label>
                            <input type="password" name="cpassword" placeholder="Confirm Password" name="" class="form-control" id="confirm_password" required="true"/>
                            <div id="cpassword_chk" class="response"></div>    
                        </div>

                        <div class="form-group col-lg-6">
                            <form:label path="name">Name</form:label>
                            <form:input path="name" name="name" placeholder="Name" class="form-control"  required="true"/>
                        </div>

                        <div class="form-group col-lg-6">
                            <form:label path="email">Email Address</form:label>
                            <form:input placeholder="Email Address" name="email" path="email" class="form-control"  required="true"/>
                        </div>

                        <div class="col-sm-6">
                            <form:checkbox class="checkbox" path="newsletter"/>Sign up for our newsletter
                        </div>

                        <div class="col-sm-6">
                            <form:checkbox class="checkbox" path="notifications"/>Send notifications to this email
                        </div><hr>
                    </div>

                    <div class="col-md-6">
                        <h3 class="dark-grey">Terms and Conditions</h3>
                        <p>
                            By clicking on "Register" you agree to The Company's' Terms and Conditions
                        </p>
                        <p>
                            While rare, prices are subject to change based on exchange rate fluctuations - should such a fluctuation happen, we may request
                            an additional payment. You have the option to request a full refund or to pay the new price.
                            blah blah
                        </p>
                        <p>
                            Should there be an error in the description or pricing of a product, we will provide you with a full refund
                        </p>
                        <p>
                            Acceptance of an order by us is dependent on our suppliers ability to provide the product.
                        </p>

                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </div>
            </section>
    </form:form>
    <!-- <div class="space"></div> -->
    <!-- footer -->
    <jsp:include page="/WEB-INF/shared/footer.jsp" />