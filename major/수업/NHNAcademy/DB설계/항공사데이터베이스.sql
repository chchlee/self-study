CREATE TABLE `Product` (
	`product_id`	INT	NOT NULL,
	`product_type`	ENUM	NOT NULL,
	`product_name`	VARCHAR(30)	NOT NULL,
	`prodcut_description`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `ticket` (
	`ticket_id`	INT	NOT NULL,
	`product_id`	INT	NOT NULL,
	`flight_schedule`	VARCHAR(50)	NOT NULL,
	`flight_leg`	VARCHAR(50)	NOT NULL	COMMENT '하나의 항공편에서 두 개의 연속된 공항(출발-도착) 사이의 구간',
	`flight_seg`	VARCHAR(50)	NOT NULL	COMMENT '발생한 여객의 탑승지 또는 화물의 탑승지부터 화물의 하기지점까지의 구간',
	`flight_price`	BIGINT	NOT NULL,
	`Departure_City`	VARCHAR(50)	NULL,
	`Arrival_City`	VARCHAR(50)	NULL,
	`Departure_Date`	DATETIME	NULL,
	`Arrival_Date`	DATETIME	NULL,
	`Seat_Amount`	INT	NULL,
	`Seat_Class`	VARCHAR(50)	NULL,
	`Boarding_Port`	VARCHAR(50)	NULL
);

CREATE TABLE `AdditionalService` (
	`additionalservice_id`	INT	NOT NULL,
	`product_id`	INT	NOT NULL,
	`additionalservice_name`	VARCHAR(30)	NOT NULL,
	`additionalservice_content`	VARCHAR(300)	NOT NULL,
	`additionalservice_price`	BIGINT	NOT NULL
);

CREATE TABLE `AffiliateProducts` (
	`affiliateproduct_id`	INT	NOT NULL,
	`product_id`	INT	NOT NULL,
	`affiliateproduct_name`	VARCHAR(30)	NOT NULL,
	`affiliateproduct_content`	VARCHAR(300)	NOT NULL,
	`affiliateproduct_price`	BIGINT	NOT NULL
);

CREATE TABLE `Accessories` (
	`accessory_id`	INT	NOT NULL,
	`product_id`	INT	NOT NULL,
	`accessory_name`	VARCHAR(30)	NOT NULL,
	`accessory_content`	VARCHAR(300)	NOT NULL,
	`accessory_price`	BIGINT	NOT NULL
);

CREATE TABLE `CombinedProducts` (
	`combinedproduct_id`	INT	NOT NULL,
	`product_id2`	INT	NOT NULL
);

CREATE TABLE `CombinedProductsDetail` (
	`combinedproductdetail_id`	INT	NOT NULL,
	`combinedproduct_id`	INT	NOT NULL,
	`ticket_id`	INT	NOT NULL,
	`additionalservice_id`	INT	NOT NULL,
	`affiliateproduct_id`	INT	NOT NULL,
	`accessory_id`	INT	NOT NULL
);

CREATE TABLE `Customer` (
	`customer_id`	INT	NOT NULL,
	`customer_type`	ENUM	NOT NULL,
	`customer_email`	VARCHAR(100)	NOT NULL,
	`customer_firstname`	VARCHAR(100)	NOT NULL,
	`customer_middlename`	VARCHAR(100)	NOT NULL,
	`customer_contact`	VARCHAR(100)	NOT NULL,
	`customer_address`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `CustomerIdentification` (
	`customeridenfication_id`	INT	NOT NULL,
	`customer_id`	INT	NOT NULL,
	`customeridentification_type`	ENUM	NOT NULL,
	`customeridentification_number`	INT	NOT NULL
);

CREATE TABLE `IndividualCustomer` (
	`individualcustomer_id`	INT	NOT NULL,
	`customer_id`	INT	NOT NULL,
	`individualcustomer_membership`	VARCHAR(30)	NOT NULL,
	`individualcustomer_birth`	DATETIME	NOT NULL,
	`individualcustomer_gender`	ENUM	NOT NULL
);

CREATE TABLE `CorporateCustomer` (
	`corporatecustomer_id`	INT	NOT NULL,
	`customer_id`	INT	NOT NULL,
	`corporate_name`	VARCHAR(100)	NOT NULL,
	`corporate_content`	VARCHAR(300)	NOT NULL,
	`corporate_discountrate`	DOUBLE	NOT NULL
);

CREATE TABLE `RegularMember` (
	`regularmember_id`	INT	NOT NULL,
	`individualcustomer_id`	INT	NOT NULL
);

CREATE TABLE `SimpleMember` (
	`simplemember_id`	INT	NOT NULL,
	`individualcustomer_id`	INT	NOT NULL,
	`simplemember_socialid`	INT	NOT NULL,
	`simplemember_socialtype`	ENUM	NOT NULL
);

CREATE TABLE `CorporateEmployee` (
	`corporateemployee_id`	INT	NOT NULL,
	`corporatecustomer_id`	INT	NOT NULL,
	`individualcustomer_id`	INT	NOT NULL
);

CREATE TABLE `CorporateBenefit` (
	`corporatebenefit_id`	INT	NOT NULL,
	`corporatecustomer_id`	INT	NOT NULL,
	`corporatecustomer_name`	VARCHAR(100)	NOT NULL,
	`corporatecustomer_content`	VARCHAR(300)	NULL,
	`corporatecustomer_discountrate`	DOUBLE	NULL
);

CREATE TABLE `PreferredFlightInfo` (
	`preferredflightinfo_id`	INT	NOT NULL,
	`customer_id`	INT	NOT NULL,
	`preferredflight_flighttype`	ENUM	NOT NULL,
	`preferredflight_seattype`	ENUM	NOT NULL,
	`preferredflight_mealtype`	ENUM	NOT NULL
);

CREATE TABLE `PNR` (
	`pnr_id`	INT	NOT NULL,
	`customer_id`	INT	NOT NULL,
	`pnr_reservationdate`	DATETIME	NOT NULL,
	`pnr_reservationtype`	ENUM	NOT NULL
);

CREATE TABLE `PAX` (
	`pax_id`	INT	NOT NULL,
	`pnr_id`	INT	NOT NULL,
	`pax_name`	VARCHAR(100)	NOT NULL,
	`pax_age`	INT	NOT NULL,
	`pax_contact`	VARCHAR(30)	NOT NULL
);

CREATE TABLE `SEG` (
	`seg_id`	INT	NOT NULL,
	`pnr_id`	INT	NOT NULL,
	`seg_departureairport`	VARCHAR(10)	NOT NULL,
	`seg_arrivalairport`	VARCHAR(10)	NOT NULL,
	`seg_departuretime`	DATETIME	NOT NULL,
	`seg_arrivaltime`	DATETIME	NOT NULL
);

CREATE TABLE `AdditionalServiceReservation` (
	`Key`	VARCHAR(255)	NOT NULL,
	`pax_id`	INT	NOT NULL,
	`pnr_id`	INT	NOT NULL,
	`seg_id`	INT	NOT NULL,
	`product_id`	INT	NOT NULL
);

CREATE TABLE `SSR` (
	`Key`	VARCHAR(255)	NOT NULL,
	`pax_id`	INT	NOT NULL,
	`pnr_id`	INT	NOT NULL,
	`seg_id`	INT	NOT NULL
);

CREATE TABLE `TICKET` (
	`ticket_id`	INT	NOT NULL,
	`pax_id`	INT	NOT NULL,
	`ticket_status`	ENUM	NOT NULL
);

CREATE TABLE `PaymentMethod` (
	`paymentmethod_id`	INT	NOT NULL,
	`paymentmethod_type`	ENUM	NOT NULL,
	`paymentmethod_date`	DATETIME	NOT NULL,
	`paymentmethod_amount`	BIGINT	NOT NULL
);

CREATE TABLE `Fare` (
	`fare_id`	INT	NOT NULL,
	`ticket_id`	INT	NOT NULL,
	`coupon_id`	int	NOT NULL
);

CREATE TABLE `Tax` (
	`tax_id`	INT	NOT NULL,
	`ticket_id`	INT	NOT NULL,
	`tax_type`	ENUM	NOT NULL,
	`tax_amount`	BIGINT	NOT NULL
);

CREATE TABLE `TICKET_PaymentMethod` (
	`ticket_id`	INT	NOT NULL,
	`paymentmethod_id`	INT	NOT NULL
);

CREATE TABLE `Coupon` (
	`coupon_id`	int	NOT NULL,
	`seg_id`	INT	NOT NULL,
	`coupon_name`	VARCHAR(100)	NOT NULL,
	`Field`	DATETIME	NULL,
	`Field2`	DATETIME	NULL,
	`Field3`	DOUBLE	NOT NULL,
	`Field4`	BOOLEAN	NOT NULL,
	`Field5`	BOOLEAN	NOT NULL,
	`Coupon_Target`	BIGINT	NULL,
	`Coupon_Minimum_Price`	BIGINT	NULL,
	`Coupon_Maximum_Price`	BIGINT	NULL
);

CREATE TABLE `Refund` (
	`refund_id`	INT	NOT NULL,
	`ticket_id`	INT	NOT NULL
);

CREATE TABLE `RefundPaymentMethod` (
	`refundpaymentmethod_id`	INT	NOT NULL,
	`refund_id`	INT	NOT NULL,
	`refundpaymentmethod_type`	ENUM	NOT NULL
);

CREATE TABLE `RefundTax` (
	`refundtax_id`	INT	NOT NULL,
	`refund_id`	INT	NOT NULL,
	`refundtax_type`	ENUM	NOT NULL,
	`refundtax_amount`	INT	NOT NULL
);

CREATE TABLE `RefundFare` (
	`refundfare_id`	INT	NOT NULL,
	`refund_id`	INT	NOT NULL,
	`refundfare_basefare`	BIGINT	NOT NULL,
	`refundfare_discounfare`	BIGINT	NOT NULL
);

CREATE TABLE `Airport` (
	`airport_id`	INT	NOT NULL,
	`airport_name`	VARCHAR(30)	NOT NULL,
	`airport_code`	VARCHAR(10)	NOT NULL,
	`airport_city`	VARCHAR(30)	NOT NULL,
	`airport_country`	VARACHR(50)	NOT NULL,
	`airport_timezone`	DATETIME	NOT NULL
);

CREATE TABLE `ATCAdvisory` (
	`advisory_id`	INT	NOT NULL,
	`airplan_id`	INT	NOT NULL,
	`atc_information`	VARCHAR(300)	NOT NULL
);

CREATE TABLE `ArrivalDeparture` (
	`arrivaldeparture_id`	INT	NOT NULL,
	`arrival_airport`	VARCHAR(50)	NOT NULL,
	`departure_airport`	VARCHAR(50)	NOT NULL,
	`arrivaldeparture_route`	VARCHAR(100)	NOT NULL,
	`arrivaldeparture_mileage`	INT	NOT NULL
);

CREATE TABLE `Untitled2` (
	`Key`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `crew` (
	`crew_id`	INT	NOT NULL,
	`crew_name`	VARCHAR(50)	NOT NULL,
	`crew_position`	VARCHAR(255)	NULL
);

CREATE TABLE `CrewComposition` (
	`crewcomposition_id`	INT	NOT NULL,
	`crew_id`	INT	NOT NULL,
	`airplan_id`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `CrewAirplan` (
	`crewairplan_id`	INT	NOT NULL,
	`airplan_id`	INT	NOT NULL,
	`crew_id`	INT	NOT NULL,
	`crewairplan_time`	INT	NOT NULL,
	`crewairplan_date`	DATE	NOT NULL
);

CREATE TABLE `Flights` (
	`Flight_ID`	VARCHAR(255)	NOT NULL,
	`Airline_ID`	VARCHAR(255)	NULL,
	`Departure_ID`	VARCHAR(255)	NULL,
	`Arrival_Airport_ID`	VARCHAR(255)	NULL,
	`Departure_Time`	VARCHAR(255)	NULL,
	`Arrival_Time`	VARCHAR(255)	NULL,
	`Distance`	VARCHAR(255)	NULL,
	`Field7`	VARCHAR(255)	NULL,
	`Field`	VARCHAR(255)	NULL,
	`Field2`	VARCHAR(255)	NULL,
	`Field3`	VARCHAR(255)	NULL,
	`Field4`	VARCHAR(255)	NULL
);

CREATE TABLE `Airports` (
	`Airport_ID`	VARCHAR(255)	NOT NULL,
	`Name`	VARCHAR(255)	NULL,
	`IATA_Code`	VARCHAR(255)	NULL,
	`ICAO_Code`	VARCHAR(255)	NULL,
	`City`	VARCHAR(255)	NULL,
	`Country`	VARCHAR(255)	NULL,
	`Field5`	VARCHAR(255)	NULL
);

CREATE TABLE `Flight_Schedule` (
	`Schedule_ID`	VARCHAR(255)	NOT NULL,
	`Flight_ID`	VARCHAR(255)	NOT NULL,
	`Available_Date`	VARCHAR(255)	NULL,
	`Season_Code`	VARCHAR(255)	NULL,
	`Field`	VARCHAR(255)	NULL,
	`Field2`	VARCHAR(255)	NULL,
	`Field3`	VARCHAR(255)	NULL
);

CREATE TABLE `Airplan` (
	`airplan_id`	INT	NOT NULL,
	`arrivaldeparture_id`	INT	NOT NULL,
	`flightpath_id`	INT	NOT NULL,
	`airplan_flight`	VARCHAR(50)	NOT NULL,
	`airplan_date`	DATETIME	NOT NULL,
	`airplan_code`	INT	NOT NULL
);

CREATE TABLE `flightpath` (
	`flightpath_id`	INT	NOT NULL
);

CREATE TABLE `Crew` (
	`Key`	VARCHAR(255)	NOT NULL,
	`Field`	VARCHAR(255)	NULL,
	`Field2`	VARCHAR(255)	NULL,
	`Field3`	VARCHAR(255)	NULL,
	`Field4`	VARCHAR(255)	NULL,
	`Field5`	VARCHAR(255)	NULL
);

ALTER TABLE `Product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`product_id`
);

ALTER TABLE `ticket` ADD CONSTRAINT `PK_TICKET` PRIMARY KEY (
	`ticket_id`,
	`product_id`
);

ALTER TABLE `AdditionalService` ADD CONSTRAINT `PK_ADDITIONALSERVICE` PRIMARY KEY (
	`additionalservice_id`,
	`product_id`
);

ALTER TABLE `AffiliateProducts` ADD CONSTRAINT `PK_AFFILIATEPRODUCTS` PRIMARY KEY (
	`affiliateproduct_id`,
	`product_id`
);

ALTER TABLE `Accessories` ADD CONSTRAINT `PK_ACCESSORIES` PRIMARY KEY (
	`accessory_id`,
	`product_id`
);

ALTER TABLE `CombinedProducts` ADD CONSTRAINT `PK_COMBINEDPRODUCTS` PRIMARY KEY (
	`combinedproduct_id`,
	`product_id2`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `PK_COMBINEDPRODUCTSDETAIL` PRIMARY KEY (
	`combinedproductdetail_id`,
	`combinedproduct_id`
);

ALTER TABLE `Customer` ADD CONSTRAINT `PK_CUSTOMER` PRIMARY KEY (
	`customer_id`
);

ALTER TABLE `CustomerIdentification` ADD CONSTRAINT `PK_CUSTOMERIDENTIFICATION` PRIMARY KEY (
	`customeridenfication_id`,
	`customer_id`
);

ALTER TABLE `IndividualCustomer` ADD CONSTRAINT `PK_INDIVIDUALCUSTOMER` PRIMARY KEY (
	`individualcustomer_id`,
	`customer_id`
);

ALTER TABLE `CorporateCustomer` ADD CONSTRAINT `PK_CORPORATECUSTOMER` PRIMARY KEY (
	`corporatecustomer_id`,
	`customer_id`
);

ALTER TABLE `RegularMember` ADD CONSTRAINT `PK_REGULARMEMBER` PRIMARY KEY (
	`regularmember_id`,
	`individualcustomer_id`
);

ALTER TABLE `SimpleMember` ADD CONSTRAINT `PK_SIMPLEMEMBER` PRIMARY KEY (
	`simplemember_id`,
	`individualcustomer_id`
);

ALTER TABLE `CorporateEmployee` ADD CONSTRAINT `PK_CORPORATEEMPLOYEE` PRIMARY KEY (
	`corporateemployee_id`,
	`corporatecustomer_id`,
	`individualcustomer_id`
);

ALTER TABLE `CorporateBenefit` ADD CONSTRAINT `PK_CORPORATEBENEFIT` PRIMARY KEY (
	`corporatebenefit_id`,
	`corporatecustomer_id`
);

ALTER TABLE `PreferredFlightInfo` ADD CONSTRAINT `PK_PREFERREDFLIGHTINFO` PRIMARY KEY (
	`preferredflightinfo_id`
);

ALTER TABLE `PNR` ADD CONSTRAINT `PK_PNR` PRIMARY KEY (
	`pnr_id`
);

ALTER TABLE `PAX` ADD CONSTRAINT `PK_PAX` PRIMARY KEY (
	`pax_id`,
	`pnr_id`
);

ALTER TABLE `SEG` ADD CONSTRAINT `PK_SEG` PRIMARY KEY (
	`seg_id`,
	`pnr_id`
);

ALTER TABLE `AdditionalServiceReservation` ADD CONSTRAINT `PK_ADDITIONALSERVICERESERVATION` PRIMARY KEY (
	`Key`,
	`pax_id`,
	`pnr_id`,
	`seg_id`,
	`product_id`
);

ALTER TABLE `SSR` ADD CONSTRAINT `PK_SSR` PRIMARY KEY (
	`Key`,
	`pax_id`,
	`pnr_id`,
	`seg_id`
);

ALTER TABLE `TICKET` ADD CONSTRAINT `PK_TICKET` PRIMARY KEY (
	`ticket_id`,
	`pax_id`
);

ALTER TABLE `PaymentMethod` ADD CONSTRAINT `PK_PAYMENTMETHOD` PRIMARY KEY (
	`paymentmethod_id`
);

ALTER TABLE `Fare` ADD CONSTRAINT `PK_FARE` PRIMARY KEY (
	`fare_id`,
	`ticket_id`,
	`coupon_id`
);

ALTER TABLE `Tax` ADD CONSTRAINT `PK_TAX` PRIMARY KEY (
	`tax_id`
);

ALTER TABLE `TICKET_PaymentMethod` ADD CONSTRAINT `PK_TICKET_PAYMENTMETHOD` PRIMARY KEY (
	`ticket_id`,
	`paymentmethod_id`
);

ALTER TABLE `Coupon` ADD CONSTRAINT `PK_COUPON` PRIMARY KEY (
	`coupon_id`,
	`seg_id`
);

ALTER TABLE `Refund` ADD CONSTRAINT `PK_REFUND` PRIMARY KEY (
	`refund_id`,
	`ticket_id`
);

ALTER TABLE `RefundPaymentMethod` ADD CONSTRAINT `PK_REFUNDPAYMENTMETHOD` PRIMARY KEY (
	`refundpaymentmethod_id`,
	`refund_id`
);

ALTER TABLE `RefundTax` ADD CONSTRAINT `PK_REFUNDTAX` PRIMARY KEY (
	`refundtax_id`,
	`refund_id`
);

ALTER TABLE `RefundFare` ADD CONSTRAINT `PK_REFUNDFARE` PRIMARY KEY (
	`refundfare_id`,
	`refund_id`
);

ALTER TABLE `Airport` ADD CONSTRAINT `PK_AIRPORT` PRIMARY KEY (
	`airport_id`
);

ALTER TABLE `ATCAdvisory` ADD CONSTRAINT `PK_ATCADVISORY` PRIMARY KEY (
	`advisory_id`,
	`airplan_id`
);

ALTER TABLE `ArrivalDeparture` ADD CONSTRAINT `PK_ARRIVALDEPARTURE` PRIMARY KEY (
	`arrivaldeparture_id`
);

ALTER TABLE `Untitled2` ADD CONSTRAINT `PK_UNTITLED2` PRIMARY KEY (
	`Key`
);

ALTER TABLE `crew` ADD CONSTRAINT `PK_CREW` PRIMARY KEY (
	`crew_id`
);

ALTER TABLE `CrewComposition` ADD CONSTRAINT `PK_CREWCOMPOSITION` PRIMARY KEY (
	`crewcomposition_id`,
	`crew_id`,
	`airplan_id`
);

ALTER TABLE `CrewAirplan` ADD CONSTRAINT `PK_CREWAIRPLAN` PRIMARY KEY (
	`crewairplan_id`,
	`airplan_id`,
	`crew_id`
);

ALTER TABLE `Flights` ADD CONSTRAINT `PK_FLIGHTS` PRIMARY KEY (
	`Flight_ID`
);

ALTER TABLE `Airports` ADD CONSTRAINT `PK_AIRPORTS` PRIMARY KEY (
	`Airport_ID`
);

ALTER TABLE `Flight_Schedule` ADD CONSTRAINT `PK_FLIGHT_SCHEDULE` PRIMARY KEY (
	`Schedule_ID`
);

ALTER TABLE `Airplan` ADD CONSTRAINT `PK_AIRPLAN` PRIMARY KEY (
	`airplan_id`,
	`arrivaldeparture_id`,
	`flightpath_id`
);

ALTER TABLE `flightpath` ADD CONSTRAINT `PK_FLIGHTPATH` PRIMARY KEY (
	`flightpath_id`
);

ALTER TABLE `Crew` ADD CONSTRAINT `PK_CREW` PRIMARY KEY (
	`Key`
);

ALTER TABLE `ticket` ADD CONSTRAINT `FK_Product_TO_ticket_1` FOREIGN KEY (
	`product_id`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `AdditionalService` ADD CONSTRAINT `FK_Product_TO_AdditionalService_1` FOREIGN KEY (
	`product_id`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `AffiliateProducts` ADD CONSTRAINT `FK_Product_TO_AffiliateProducts_1` FOREIGN KEY (
	`product_id`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `Accessories` ADD CONSTRAINT `FK_Product_TO_Accessories_1` FOREIGN KEY (
	`product_id`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `CombinedProducts` ADD CONSTRAINT `FK_Product_TO_CombinedProducts_1` FOREIGN KEY (
	`product_id2`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `FK_CombinedProducts_TO_CombinedProductsDetail_1` FOREIGN KEY (
	`combinedproduct_id`
)
REFERENCES `CombinedProducts` (
	`combinedproduct_id`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `FK_ticket_TO_CombinedProductsDetail_1` FOREIGN KEY (
	`ticket_id`
)
REFERENCES `ticket` (
	`ticket_id`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `FK_AdditionalService_TO_CombinedProductsDetail_1` FOREIGN KEY (
	`additionalservice_id`
)
REFERENCES `AdditionalService` (
	`additionalservice_id`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `FK_AffiliateProducts_TO_CombinedProductsDetail_1` FOREIGN KEY (
	`affiliateproduct_id`
)
REFERENCES `AffiliateProducts` (
	`affiliateproduct_id`
);

ALTER TABLE `CombinedProductsDetail` ADD CONSTRAINT `FK_Accessories_TO_CombinedProductsDetail_1` FOREIGN KEY (
	`accessory_id`
)
REFERENCES `Accessories` (
	`accessory_id`
);

ALTER TABLE `CustomerIdentification` ADD CONSTRAINT `FK_Customer_TO_CustomerIdentification_1` FOREIGN KEY (
	`customer_id`
)
REFERENCES `Customer` (
	`customer_id`
);

ALTER TABLE `IndividualCustomer` ADD CONSTRAINT `FK_Customer_TO_IndividualCustomer_1` FOREIGN KEY (
	`customer_id`
)
REFERENCES `Customer` (
	`customer_id`
);

ALTER TABLE `CorporateCustomer` ADD CONSTRAINT `FK_Customer_TO_CorporateCustomer_1` FOREIGN KEY (
	`customer_id`
)
REFERENCES `Customer` (
	`customer_id`
);

ALTER TABLE `RegularMember` ADD CONSTRAINT `FK_IndividualCustomer_TO_RegularMember_1` FOREIGN KEY (
	`individualcustomer_id`
)
REFERENCES `IndividualCustomer` (
	`individualcustomer_id`
);

ALTER TABLE `SimpleMember` ADD CONSTRAINT `FK_IndividualCustomer_TO_SimpleMember_1` FOREIGN KEY (
	`individualcustomer_id`
)
REFERENCES `IndividualCustomer` (
	`individualcustomer_id`
);

ALTER TABLE `CorporateEmployee` ADD CONSTRAINT `FK_CorporateCustomer_TO_CorporateEmployee_1` FOREIGN KEY (
	`corporatecustomer_id`
)
REFERENCES `CorporateCustomer` (
	`corporatecustomer_id`
);

ALTER TABLE `CorporateEmployee` ADD CONSTRAINT `FK_IndividualCustomer_TO_CorporateEmployee_1` FOREIGN KEY (
	`individualcustomer_id`
)
REFERENCES `IndividualCustomer` (
	`individualcustomer_id`
);

ALTER TABLE `CorporateBenefit` ADD CONSTRAINT `FK_CorporateCustomer_TO_CorporateBenefit_1` FOREIGN KEY (
	`corporatecustomer_id`
)
REFERENCES `CorporateCustomer` (
	`corporatecustomer_id`
);

ALTER TABLE `PreferredFlightInfo` ADD CONSTRAINT `FK_Customer_TO_PreferredFlightInfo_1` FOREIGN KEY (
	`customer_id`
)
REFERENCES `Customer` (
	`customer_id`
);

ALTER TABLE `PNR` ADD CONSTRAINT `FK_Customer_TO_PNR_1` FOREIGN KEY (
	`customer_id`
)
REFERENCES `Customer` (
	`customer_id`
);

ALTER TABLE `PAX` ADD CONSTRAINT `FK_PNR_TO_PAX_1` FOREIGN KEY (
	`pnr_id`
)
REFERENCES `PNR` (
	`pnr_id`
);

ALTER TABLE `SEG` ADD CONSTRAINT `FK_PNR_TO_SEG_1` FOREIGN KEY (
	`pnr_id`
)
REFERENCES `PNR` (
	`pnr_id`
);

ALTER TABLE `AdditionalServiceReservation` ADD CONSTRAINT `FK_PAX_TO_AdditionalServiceReservation_1` FOREIGN KEY (
	`pax_id`
)
REFERENCES `PAX` (
	`pax_id`
);

ALTER TABLE `AdditionalServiceReservation` ADD CONSTRAINT `FK_PAX_TO_AdditionalServiceReservation_2` FOREIGN KEY (
	`pnr_id`
)
REFERENCES `PAX` (
	`pnr_id`
);

ALTER TABLE `AdditionalServiceReservation` ADD CONSTRAINT `FK_SEG_TO_AdditionalServiceReservation_1` FOREIGN KEY (
	`seg_id`
)
REFERENCES `SEG` (
	`seg_id`
);

ALTER TABLE `AdditionalServiceReservation` ADD CONSTRAINT `FK_Product_TO_AdditionalServiceReservation_1` FOREIGN KEY (
	`product_id`
)
REFERENCES `Product` (
	`product_id`
);

ALTER TABLE `SSR` ADD CONSTRAINT `FK_PAX_TO_SSR_1` FOREIGN KEY (
	`pax_id`
)
REFERENCES `PAX` (
	`pax_id`
);

ALTER TABLE `SSR` ADD CONSTRAINT `FK_PAX_TO_SSR_2` FOREIGN KEY (
	`pnr_id`
)
REFERENCES `PAX` (
	`pnr_id`
);

ALTER TABLE `SSR` ADD CONSTRAINT `FK_SEG_TO_SSR_1` FOREIGN KEY (
	`seg_id`
)
REFERENCES `SEG` (
	`seg_id`
);

ALTER TABLE `TICKET` ADD CONSTRAINT `FK_PAX_TO_TICKET_1` FOREIGN KEY (
	`pax_id`
)
REFERENCES `PAX` (
	`pax_id`
);

ALTER TABLE `Fare` ADD CONSTRAINT `FK_TICKET_TO_Fare_1` FOREIGN KEY (
	`ticket_id`
)
REFERENCES `TICKET` (
	`ticket_id`
);

ALTER TABLE `Fare` ADD CONSTRAINT `FK_Coupon_TO_Fare_1` FOREIGN KEY (
	`coupon_id`
)
REFERENCES `Coupon` (
	`coupon_id`
);

ALTER TABLE `Tax` ADD CONSTRAINT `FK_TICKET_TO_Tax_1` FOREIGN KEY (
	`ticket_id`
)
REFERENCES `TICKET` (
	`ticket_id`
);

ALTER TABLE `TICKET_PaymentMethod` ADD CONSTRAINT `FK_TICKET_TO_TICKET_PaymentMethod_1` FOREIGN KEY (
	`ticket_id`
)
REFERENCES `TICKET` (
	`ticket_id`
);

ALTER TABLE `TICKET_PaymentMethod` ADD CONSTRAINT `FK_PaymentMethod_TO_TICKET_PaymentMethod_1` FOREIGN KEY (
	`paymentmethod_id`
)
REFERENCES `PaymentMethod` (
	`paymentmethod_id`
);

ALTER TABLE `Coupon` ADD CONSTRAINT `FK_SEG_TO_Coupon_1` FOREIGN KEY (
	`seg_id`
)
REFERENCES `SEG` (
	`seg_id`
);

ALTER TABLE `Refund` ADD CONSTRAINT `FK_TICKET_TO_Refund_1` FOREIGN KEY (
	`ticket_id`
)
REFERENCES `TICKET` (
	`ticket_id`
);

ALTER TABLE `RefundPaymentMethod` ADD CONSTRAINT `FK_Refund_TO_RefundPaymentMethod_1` FOREIGN KEY (
	`refund_id`
)
REFERENCES `Refund` (
	`refund_id`
);

ALTER TABLE `RefundTax` ADD CONSTRAINT `FK_Refund_TO_RefundTax_1` FOREIGN KEY (
	`refund_id`
)
REFERENCES `Refund` (
	`refund_id`
);

ALTER TABLE `RefundFare` ADD CONSTRAINT `FK_Refund_TO_RefundFare_1` FOREIGN KEY (
	`refund_id`
)
REFERENCES `Refund` (
	`refund_id`
);

ALTER TABLE `ATCAdvisory` ADD CONSTRAINT `FK_Airplan_TO_ATCAdvisory_1` FOREIGN KEY (
	`airplan_id`
)
REFERENCES `Airplan` (
	`airplan_id`
);

ALTER TABLE `CrewComposition` ADD CONSTRAINT `FK_crew_TO_CrewComposition_1` FOREIGN KEY (
	`crew_id`
)
REFERENCES `crew` (
	`crew_id`
);

ALTER TABLE `CrewComposition` ADD CONSTRAINT `FK_Airplan_TO_CrewComposition_1` FOREIGN KEY (
	`airplan_id`
)
REFERENCES `Airplan` (
	`airplan_id`
);

ALTER TABLE `CrewAirplan` ADD CONSTRAINT `FK_Airplan_TO_CrewAirplan_1` FOREIGN KEY (
	`airplan_id`
)
REFERENCES `Airplan` (
	`airplan_id`
);

ALTER TABLE `CrewAirplan` ADD CONSTRAINT `FK_crew_TO_CrewAirplan_1` FOREIGN KEY (
	`crew_id`
)
REFERENCES `crew` (
	`crew_id`
);

ALTER TABLE `Flight_Schedule` ADD CONSTRAINT `FK_Flights_TO_Flight_Schedule_1` FOREIGN KEY (
	`Flight_ID`
)
REFERENCES `Flights` (
	`Flight_ID`
);

ALTER TABLE `Airplan` ADD CONSTRAINT `FK_ArrivalDeparture_TO_Airplan_1` FOREIGN KEY (
	`arrivaldeparture_id`
)
REFERENCES `ArrivalDeparture` (
	`arrivaldeparture_id`
);

ALTER TABLE `Airplan` ADD CONSTRAINT `FK_flightpath_TO_Airplan_1` FOREIGN KEY (
	`flightpath_id`
)
REFERENCES `flightpath` (
	`flightpath_id`
);

