<!-- 
	common url api /ui-api/GROUP_NAME/METHOD_NAME 
	object config {navigation.vue, router.js}
	app config {3 functions, get all, savelist settings for JSON Object}
-->
<template>
    <div>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">App Configuration</h1>
    	<div class="primary-section">
	        <form @submit="submitUrl">
	        	<label class="slds-form-element__label">{{ title }}</label>
	    		<input type="text" v-model="salesForceUrl" placeholder="https://environment--intcs105.my.salceforce.com"/>
	    		<input class="slds-button slds-button_brand" type="submit" value="Save"/>
	    	</form>
    	</div>
    	<h1 class="slds-text-heading_large slds-m-bottom_x-large">SF API credentials</h1>
    	<div class="primary-section">
    		<form @submit="submitCredentials">
    			<label class="slds-form-element__label">Username</label> 
    			<input type="text" v-model="username" placeholder="darango@mycervello.com"/>
    			<label class="slds-form-element__label">Password</label>
    			<input type="text" v-model="password" placeholder="******"/>
    			<label class="slds-form-element__label">Token</label>
    			<input type="text" v-model="token" placeholder="*********"/>
    			<input class="slds-button slds-button_brand" type="submit" value="Save" />
    		</form>
    	</div>
    </div>
</template>
<script>
    export default {
    	data() {
    		return {
    			title: 'Base Salesforce URL',
    			salesForceUrl: null,
    			description: null,
    			username: null,
    			password: null,
    			token: null
    		}
    	},
    	methods: {
    		getall() {
    			fetch('#').then(response => {
    				if(response.ok) {
    					return response.json();
    				}
    			}).then(jsonResponse => {
    				console.log(`Request Successful ${jsonResponse}`);
    			})
    		},
    		submitUrl() {

    		},
    		submitCredentials() {

    		}
    	},
    	mounted() {
    		this.getall();
    	}
    }
</script>

<style scoped>

</style>
