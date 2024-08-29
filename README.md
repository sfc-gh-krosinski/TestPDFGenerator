# Simple Test PDFs Generator
Created for generating test data in the unstructured data (sharepoint connector) project and for the cortex feeding. 
## Input
You can provide an int parameter, which will provide the number of files to be generated. If no (or wrong) parameter is provided, the default number of files will be generated. The current default is set to 10000.
## Outcome
Generates number random PDFs containing text: 
> In the year [random year 1920-2024] we produced [random int] [random color] cars.

Generated files are stored in the **filesGenerated** folder under the project root. 
