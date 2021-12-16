### MyVeriffAssignmentPavlishina
# Veriff Demo test plan

### Introduction

- First it should be analize what is more reasonable to test manually and what makes more sense to be automated.

#### Manual:
- General view of the page: margins, spaces, overlaps, fonts, text size etc.

#### Automation:
- Element-based things (everything where "big picture" human view is not necessary).

- Secondly, more presize requirements for the functionality should be got. As long as we don't have certain requirements, wetest as per common sense.

### Test sections:

In current work only Configuration page is to be tested. The elements of other pages will be used only to make sure that we got to the right page.

#### Visual part
- 1.1. As it is noticed, one of lower paragraphs starts with bold font ("by starting"). As per common sense, it does not look correct - BUG-1 (unless there are specific business requirements).
- 1.2. Page elements: paragraphs, fields, buttons - seem to be allocated properly - AUTOMATED
- 1.3. Texts also look fine.

#### Functional part
- 2.1. The form with empty data can be sent. As there is no clear requirements, we cannot make sure if it is supposed to be allowed or not. So the test is written according to 
"it should be allowed". AUTOMATED.
- 2.2. Similar situation with wrong name format, like "Anna1" or "@alex Johnson". As the name will be verified anyway in further steps, it does not matter if the user enters
forbidden symwols or not - the name will be compared with what is written on the document. So maybe  this check is not needed here. AUTOMATED.
- 2.3. Language and Country are just selected ranomly (because there is same setup for all values). AUTOMATED
- 2.4. As it is seen, there are 2 configurations: document types (4) and launch types (2). All combinations are tested (8 combinations are in whole). With the last step we make sure,
that the user sees the element of Verification (next) page. AUTOMATED. The setup with Residence permit & (any launch type) is not submitted. BUG-2. AUTOMATED
- 2.5. Also we make sure, that the user can return / closefurther oages to return to initial Configuration page. While it works fine with in-context, it does not work as expected 
with redirected. AUTOMATED. BUG-3. AUTOMATED.

#### Conclusion
I would not go live with the product. While BUG-1 and BUG-3 are Minor or Medium BUG-2 is more like Critical, because people with certain type of document cannot even be verified.
