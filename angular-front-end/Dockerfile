FROM node:latest as build

#set tge working directory
WORKDIR /usr/local/app

#Add the source code to app
COPY ./ /usr/local/app

#Install all the dependencies
RUN npm install

#Generate the build of the application
RUN npm run build

#------#
#Use official nginw image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents
COPY --from=build /usr/local/app/dist/angular-front-end /usr/share/nginx/html

#Expose port 80
EXPOSE 80

