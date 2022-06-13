package com.kit.movie.web.validation;

import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.web.dto.timetable.TimetableSaveRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SaleValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Timetable.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Timetable timetable = (Timetable) target;

        if (timetable.getPercentDiscount() == null || timetable.getPercentDiscount() < 0 || timetable.getPercentDiscount() > 100) {
            errors.rejectValue("percentDiscount","range", new Object[]{0,100},null);
        }
        if (timetable.getFlatDiscount()== null || timetable.getFlatDiscount()<5000) {
            errors.rejectValue("flatDiscount","min", new Object[]{5000}, null);
        }
//        if (bookForm.getPrice() != null && bookForm.getStockQuantity() != null) {
//            int resultPrice = bookForm.getPrice() * bookForm.getStockQuantity();
//            if (resultPrice < 10000) {
//                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
//            }
//        }
    }
}
